(ns aoc.day3
  (:require [clojure.set :as set]
            [aoc.core :as core]))

(def regex  #"#(\d+) @ (\d+),(\d+): (\d+)x(\d+)")

(defn parsed-line
  [line]
  (let [[_ id x y width high] (re-matches regex line)]
    {:id    (Integer/parseInt id)
     :x     (Integer/parseInt x)
     :y     (Integer/parseInt y)
     :width (Integer/parseInt width)
     :high  (Integer/parseInt high)}))

(defn maybe-inc-overlap
  [result-map
   [x y id]]
  (let [coord-key (keyword (str x "-" y))]
    (if (coord-key result-map)
      (-> result-map
          (update-in [coord-key :overlaps] inc)
          (update-in [coord-key :ids] conj id))
      (conj result-map {coord-key {:overlaps 1
                                   :ids      [id]}}))))

(defn check-overlaps
  [result-map
   {:keys [id x y width high]}]
  (let [points-info (for [x (range x (+ x width))
                          y (range y (+ y high))]
                      [x y id])]
    (reduce maybe-inc-overlap result-map points-info)))

(defn part01
  [input]
  (let [cartesian_coord_list (mapv #(parsed-line %) input)
        result-map           (reduce check-overlaps {} cartesian_coord_list)
        overlaps>1           (into {} (filter (fn [[_ v]] (-> v :overlaps (> 1))) result-map))]
    (count overlaps>1)))

(defn part02
  [input]
  (let [ids                  (set (range 1 (inc (count input))))
        cartesian_coord_list (mapv #(parsed-line %) input)
        result-map           (reduce check-overlaps {} cartesian_coord_list)
        overlaps>1           (into {} (filter (fn [[_ v]] (-> v :overlaps (> 1))) result-map))
        overlapped-ids       (->> overlaps>1 vals (map :ids) (apply concat) set)]
    (first (set/difference ids overlapped-ids))))

(defn solver []
  (core/solve-day 3 part01 part02))
