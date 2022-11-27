(ns aoc.day1
  (:require [aoc.core :as core]))

(defn part01
  [input]
  (transduce (map #(Integer/parseInt %)) + input))

(defn parsed-input
  [input]
  (map #(Integer/parseInt %) input))

(defn check-repeated
  [[frequencies-reached curr-frequency] new-range]
  (let [new-frequency (+ curr-frequency new-range)]
    (if (frequencies-reached new-frequency)
      (reduced new-frequency)
      [(conj frequencies-reached new-frequency) new-frequency])))

(defn part02
  [input]
  (let [frequency-list (parsed-input input)]
    (reduce check-repeated [#{0} 0] (cycle frequency-list))))

(defn solver []
  (core/solve-day 1 part01 part02))
