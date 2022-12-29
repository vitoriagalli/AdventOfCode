(ns aoc.core
  (:require [aoc.day01 :as day1]
            [aoc.day02 :as day2]
            [aoc.day03 :as day3]
            [aoc.day04 :as day4]
            [aoc.day05 :as day5]
            [aoc.day06 :as day6]
            [aoc.day07 :as day7]
            [aoc.day08 :as day8]
            [aoc.day09 :as day9]
            [aoc.day10 :as day10]
            [aoc.day11 :as day11]
            [clojure.string :as str]))

(def fn-days [0
              day1/solver
              day2/solver
              day3/solver
              day4/solver
              day5/solver
              day6/solver
              day7/solver
              day8/solver
              day9/solver
              day10/solver
              day11/solver])

(defn read-file
  [day]
  (let [file-path    (str "data/day" day ".txt")
        file-content (slurp file-path)]
    (str/split-lines file-content)))

(defn fn-solve
  [fn args]
  (when fn
    (fn args)))

(defn solve-day
  [{day       :day
    fn-part01 :fn1
    fn-part02 :fn2}]
  (let [line-coll     (read-file day)
        answer-part01 (fn-solve fn-part01 line-coll)
        answer-part02 (fn-solve fn-part02 line-coll)]
    (println "---- day" day "------")
    (println "part 1: " answer-part01)
    (println "part 2: " answer-part02)))

(defn get-days-to-solve
  [args]
  (if (empty? args)
    (range 1 (count fn-days))
    (map #(Integer/parseInt %) args)))

(defn -main
  [& args]
  (let [days-to-solve (get-days-to-solve args)]
    (doseq [day days-to-solve]
      (solve-day (get fn-days day)))))
