(ns aoc.day2-test
  (:require [aoc.day2 :as day02]
            [clojure.test :refer :all]))

(def input ["A Y"
            "B X"
            "C Z"])

(deftest part1
  (testing "part01"
    (is (= 15
           (day02/part01 input)))))

(deftest part2
  (testing "part02"
    (is (= 12
           (day02/part02 input)))))
