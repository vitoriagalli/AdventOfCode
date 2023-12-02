(ns aoc.day2
  (:require [aoc.core :as core]))

(defn maybe-inc-occurrence
  [box-candidate n curr-result]
  (let [frequency-vals (-> (frequencies box-candidate) vals)]
    (if ((set frequency-vals) n)
      (inc curr-result)
      curr-result)))

(defn check-occurrence
  [{two :2  three :3} box-candidate]
  {:2 (maybe-inc-occurrence box-candidate 2 two)
   :3 (maybe-inc-occurrence box-candidate 3 three)})

(defn part01
  [input]
  (let [occur-map (reduce check-occurrence {:2 0 :3 0} input)]
    (* (:2 occur-map) (:3 occur-map))))


(defn string->byte-vec
  [string]
  (mapv byte (vec string)))

(defn differ-by-one-char?
  [vec1 vec2]
  (let [chars-to-cmp (dec (count vec1))
        diff-chars   (map #(- %1 %2) vec1 vec2)
        n-zero       ((frequencies diff-chars) (long 0))]
    (= n-zero chars-to-cmp)))

(defn check-common-letters
  [str1 str2]
  (let [vec1 (string->byte-vec str1)
        vec2 (string->byte-vec str2)]
    (when (differ-by-one-char? vec1 vec2)
      (->> str1
           (map #(when (= %1 %2) %1) str2)
           (keep identity)
           (apply str)))))

(defn part02
  [input]
  (-> (for [x input y input
            :let [result (check-common-letters x y)]
            :when (some? result)]
        result)
      first))

(defn solver []
  (core/solve-day 2 part01 part02))
