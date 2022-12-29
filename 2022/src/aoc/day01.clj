(ns aoc.day01)

(defn sum-on-last-element
  [collection number]
  (let [last-element (last collection)
        sum          (+ number (first last-element))]
    (conj (pop collection) [sum])))

(defn calculate-calories
  [collection line]
  (if (empty? line)
    (conj collection [0])
    (sum-on-last-element collection (Integer/parseInt line))))

(defn part01
  [input]
  (->> (reduce calculate-calories [[0]] input)
       flatten
       (apply max)))

(defn part02
  [input]
  (->> (reduce calculate-calories [[0]] input)
       flatten
       sort
       reverse
       (take 3)
       (reduce +)))

(def solver
  {:day 1
   :fn1 part01
   :fn2 part02})
