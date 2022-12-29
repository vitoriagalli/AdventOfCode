(ns aoc.day10
  (:require [clojure.string :as str]))

(def n-cycles [20 60 100 140 180 220])
(def n-row 40)

(defn parsed-input
  [line]
  (let [[op val] (str/split line #" ")]
    (case op
      "noop" [0]
      "addx" [0 (Integer/parseInt val)])))

(defn pixel
  [index value]
  (if (<= (dec value) (mod index 40) (inc value))
    \#
    \.))

(defn part01
  [input]
  (let [circuit  (flatten [1 (mapcat parsed-input input)])
        x-values (reductions + circuit)]
    (->> (for [n-cycle n-cycles]
           (* n-cycle (nth x-values (dec n-cycle))))
         (apply +))))

(defn part2 [input]
  (let [circuit      (flatten [1 (mapcat parsed-input input)])
        x-values     (reductions + circuit)
        pixel-map    (map-indexed pixel x-values)
        pixel-cycles (partition n-row pixel-map)]
    (map (partial apply str) pixel-cycles)))

(defn part02
  [input]
  (let [sol (part2 input)]
    (mapv println sol)
    nil))

(def solver
  {:day 10
   :fn1 part01
   :fn2 part02})
