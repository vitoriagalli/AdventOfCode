(ns aoc.day08
  (:require [clojure.core.matrix :as m]
            [clojure.string :as str]))

(defn parsed-input
  [line]
  (->> (str/split line #"")
       (mapv #(Integer/parseInt %))))

(defn coordinates
  [matrix]
  (let [xn (count matrix)
        yn (count (first matrix))]
    (for [x (range xn)
          y (range yn)]
      [x y])))

(defn get-value
  [matrix [x y]]
  (-> matrix (get y) (get x)))

(defn radial-trees
  [m [x y]]
  (let [[lefts [_ & rights]] (split-at x (m/get-row m y))
        [tops [_ & bottoms]] (split-at y (m/get-column m x))]
    [(reverse lefts) rights (reverse tops) bottoms]))

(defn take-while-fn
  [pred coll]
  (lazy-seq
   (when-let [s (seq coll)]
     (let [x (first s)]
       (cons x (when-not (pred x) (take-while-fn pred (rest s))))))))

(defn visible?
  [matrix coord]
  (let [max (get-value matrix coord)]
    (->> coord
         (radial-trees matrix)
         (some (fn [vec] (every? #(> max %) vec))))))

(defn scenic-scores
  [matrix coord]
  (let [spot-height (get-value matrix coord)]
    (->> coord
         (radial-trees matrix)
         (map #(count (take-while-fn (fn [height] (>= height spot-height)) %)))
         (apply *))))

(defn solve-trees
  [fn-solver input]
  (let [trees (mapv parsed-input input)
        coord (coordinates trees)]
    (map (partial fn-solver trees) coord)))

(defn part01
  [input]
  (->> input
       (solve-trees visible?)
       (keep identity)
       count))

(defn part02
  [input]
  (->> input
       (solve-trees scenic-scores)
       (apply max)))

(def solver
  {:day 8
   :fn1 part01
   :fn2 part02})
