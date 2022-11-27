(ns aoc.core
  (:require [clojure.string :as str]))

(defn read-file
  [day]
  (let [file-path (str "data/day" day ".txt")
        file-content (slurp file-path)]
    (str/split-lines file-content)))

(defn fn-solve
  [fn args]
  (when fn
    (fn args)))

(defn solve-day
  [day fn-part01 fn-part02]
  (let [line-coll     (read-file day)
        answer-part01 (fn-solve fn-part01 line-coll)
        answer-part02 (fn-solve fn-part02 line-coll)]
    (println "---- day" day "------")
    (println "part 1: " answer-part01)
    (println "part 2: " answer-part02)))



