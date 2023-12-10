(ns aoc.day2
  (:require [aoc.core :as core]
            [clojure.string :as string]))

(def constraints
  {:blue  14
   :red   12
   :green 13})

(defn ^:private parse-line
  [line]
  (let [[[_ id subsets-str]] (re-seq #"Game (\d+): (.+?)$" line)
        subsets (string/split subsets-str #"; ")]
    {(Integer/parseInt id)
     (vec (for [subset subsets]
            (transduce (map #(let [[units color] (string/split % #" ")]
                               {(keyword color) (Integer/parseInt units)}))
                       conj {} (clojure.string/split subset #", "))))}))

(defn ^:private valid-game?
  [constraints [_id rounds]]
  (every? (fn [round]
            (every? (fn [[color units]]
                      (<= units (constraints color)))
                    round))
          rounds))

(defn solve-part1
  [input]
  (let [parsed-input (transduce (map parse-line) conj {} input)]
    (->> parsed-input
         (filter (partial valid-game? constraints))
         keys
         (reduce + 0))))

(defmethod core/part1 2
  [_day
   input]
  (solve-part1 input))

(defn ^:private maximum-units
  [[_id rounds]]
  (reduce
   (fn [max-units round-to-compare]
     (merge-with max max-units round-to-compare))
   {}
   rounds))

(defn solve-part2
  [input]
  (let [parsed-input (transduce (map parse-line) conj {} input)]
    (->> parsed-input
         (map maximum-units)
         (map vals)
         (transduce (map #(apply * %)) + 0))))

(defmethod core/part2 2
  [_day
   input]
  (solve-part2 input))
