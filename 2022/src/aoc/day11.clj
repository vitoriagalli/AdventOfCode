(ns aoc.day11
  (:require [clojure.string :as str]))

(def n-monkey-regex #"Monkey (\d+):")
(def items-regex #"Starting items: ([\d\s\,]+)")
(def operation-regex #"Operation: new = ([\d\w]+) (.) ([\d\w]+)")
(def test-regex #"Test: divisible by (\d+)")
(def true-regex #"If true: throw to monkey (\d+)")
(def false-regex #"If false: throw to monkey (\d+)")

(defn lcm
  [& xs]
  (/ (apply * xs)
     (reduce #(if (zero? %2) % (recur %2 (mod % %2))) xs)))

(def levels
  {:1 {:rounds 20 :manage-level (fn [level _] (bigint (/ level 3)))}
   :2 {:rounds 10000 :manage-level (fn [level div-mod] (mod level div-mod))}})

(defn parsed-monkey
  [monkey-line]
  (->> monkey-line
       (re-matches n-monkey-regex)
       second
       Integer/parseInt))

(defn parsed-items
  [items-line]
  (let [[_ items-str] (re-matches items-regex items-line)
        list (str/split items-str #", ")]
    (mapv #(Integer/parseInt %) list)))

(defn parsed-operation
  [operation-line]
  (let [[_ op1-str operation-str op2-str] (re-matches operation-regex operation-line)
        operation (load-string operation-str)
        op1       (if (= "old" op1-str) nil (Integer/parseInt op1-str))
        op2       (if (= "old" op2-str) nil (Integer/parseInt op2-str))]
    [operation op1 op2]))

(defn parsed-number
  [line regex]
  (->> line
       (re-matches regex)
       second
       Integer/parseInt))

(defn parsed-input
  [monkey-map
   [monkey-line
    items-line
    operation-line
    test-line
    true-line
    false-line]]
  (let [monkey-n     (parsed-monkey (str/trim monkey-line))
        items        (parsed-items (str/trim items-line))
        [operation op1 op2] (parsed-operation (str/trim operation-line))
        divisible-by (parsed-number (str/trim test-line) test-regex)
        if-true      (parsed-number (str/trim true-line) true-regex)
        if-false     (parsed-number (str/trim false-line) false-regex)]
    (conj monkey-map
          {monkey-n {:items        items
                     :operation    operation
                     :op1          op1
                     :op2          op2
                     :divisible-by divisible-by
                     :if-true      if-true
                     :if-false     if-false
                     :inspections  0}})))

(defn round-on-monkey
  [manage-level-fn
   div-mod
   {:keys [:operation
           :op1
           :op2
           :divisible-by
           :if-true
           :if-false]}
   monkeys-info
   item]
  (let [level       (bigint (operation (or op1 item) (or op2 item)))
        worry-level (manage-level-fn level div-mod)
        to-monkey   (if (= (/ worry-level divisible-by)
                           (quot worry-level divisible-by))
                      if-true
                      if-false)]
    (update-in monkeys-info [to-monkey :items] conj worry-level)))

(defn round
  [level
   div-mod
   monkeys-info
   index]
  (let [monkey           (get monkeys-info index)
        items            (:items monkey)
        new-monkeys-info (-> monkeys-info
                             (assoc-in [index :items] [])
                             (update-in [index :inspections] #(+ (count items) %)))]
    (reduce (partial round-on-monkey (:manage-level level) div-mod monkey) new-monkeys-info items)))

(defn solve-inspections
  [level
   input]
  (let [aggregated-input (->> input
                              (remove empty?)
                              (partition 6))
        parsed-input     (reduce parsed-input {} aggregated-input)
        rounds           (->> parsed-input
                              count
                              range
                              (repeat (:rounds level))
                              flatten)
        div-mod          (->> parsed-input
                              (mapv #(-> % val :divisible-by))
                              (apply lcm))
        final-round      (reduce (partial round level div-mod) parsed-input rounds)]
    (->> final-round
         vals
         (map :inspections)
         sort
         reverse
         (take 2)
         (apply *))))

(defn part01
  [input]
  (solve-inspections (:1 levels) input))

(defn part02
  [input]
  (solve-inspections (:2 levels) input))

(def solver
  {:day 11
   :fn1 part01
   :fn2 part02})
