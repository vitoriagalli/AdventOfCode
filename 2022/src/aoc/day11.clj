(ns aoc.day11
  (:require [clojure.string :as str]))

(def n-monkey-regex #"Monkey (\d+):")
(def items-regex #"Starting items: ([\d\s\,]+)")
(def operation-regex #"Operation: new = ([\d\w]+) (.) ([\d\w]+)")
(def test-regex #"Test: divisible by (\d+)")
(def true-regex #"If true: throw to monkey (\d+)")
(def false-regex #"If false: throw to monkey (\d+)")

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
  [{:keys [:operation
           :op1
           :op2
           :divisible-by
           :if-true
           :if-false]}
   monkeys-info
   item]
  (let [worry-level (-> (operation (or op1 item) (or op2 item))
                        (/ 3)
                        int)
        to-monkey   (if (int? (/ worry-level divisible-by)) if-true if-false)]
    (update-in monkeys-info [to-monkey :items] conj worry-level)))

(defn round
  [monkeys-info
   index]
  (let [monkey           (get monkeys-info index)
        items            (:items monkey)
        new-monkeys-info (-> monkeys-info
                             (assoc-in [index :items] [])
                             (update-in [index :inspections] #(+ (count items) %)))]
    (reduce (partial round-on-monkey monkey) new-monkeys-info items)))

(defn part01
  [input]
  (let [aggregated-input (->> input
                              (remove empty?)
                              (partition 6))
        parsed-input     (reduce parsed-input {} aggregated-input)
        rounds           (->> parsed-input
                              count
                              range
                              (repeat 20)
                              flatten)
        final-round      (reduce round parsed-input rounds)]
    (->> final-round
         vals
         (map :inspections)
         sort
         reverse
         (take 2)
         (apply *))
    ))

(defn part02
  [input]
  1)

(def solver
  {:day 11
   :fn1 part01
   :fn2 part02})
