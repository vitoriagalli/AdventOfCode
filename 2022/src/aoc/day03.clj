(ns aoc.day03)

(def n1parts 2)
(def n2parts 3)

(defn get-item
  [line]
  (let [compartments  (split-at (/ (count line) n1parts) line)
        repeated-item (for [comp1 (first compartments)
                            comp2 (last compartments)
                            :when (= comp1 comp2)]
                        comp1)]
    (set repeated-item)))

(defn calculate-priorities
  [item]
  (let [subtract (if (Character/isUpperCase item) 38 96)]
    (- (int item) subtract)))

(defn part01
  [input]
  (let [items (transduce (map #(get-item %)) into [] input)]
    (transduce (map #(calculate-priorities %)) + items)))

(defn get-next-item
  [lines]
  (let [compartments  (take n2parts lines)
        repeated-item (for [comp1 (first compartments)
                            comp2 (second compartments)
                            comp3 (last compartments)
                            :when (= comp1 comp2 comp3)]
                        comp1)]
    (set repeated-item)))

(defn part02
  [input]
  (loop [lines          input
         repeated-items []]
    (if (empty? lines)
      (transduce (map #(calculate-priorities %)) + repeated-items)
      (let [repeated-item (get-next-item lines)]
        (recur (drop n2parts lines) (into repeated-items repeated-item))))))

(def solver
  {:day 3
   :fn1 part01
   :fn2 part02})
