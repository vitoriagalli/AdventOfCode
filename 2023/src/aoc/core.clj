(ns aoc.core
  (:require [clojure.string :as str]))

(defmulti part1 (fn [day _input] day))

(defmethod part1 :default
  [_day
   _input]
  "Not implemented")

(defmulti part2 (fn [day _input] day))

(defmethod part2 :default
  [_day
   _input]
  "Not implemented")

(defn read-file
  [day]
  (let [file-path    (str "data/day" day ".txt")
        file-content (slurp file-path)]
    (str/split-lines file-content)))

(defn -main
  [& args]
  (doseq [day-str args]
    (let [lines         (read-file day-str)
          day           (Integer/parseInt day-str)
          answer-part01 (part1 day lines)
          answer-part02 (part2 day lines)]
      (println "---- day" day "------")
      (println "part 1: " answer-part01)
      (println "part 2: " answer-part02))))
