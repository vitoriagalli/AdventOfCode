(ns aoc.day04-test
  (:require [aoc.day04 :as day04]
            [clojure.test :refer :all]))

(def input ["2-4,6-8"
            "2-3,4-5"
            "5-7,7-9"
            "2-8,3-7"
            "6-6,4-6"
            "2-6,4-8"])

(deftest part1
  (testing "part01"
    (is (= 2
           (day04/part01 input)))))

(deftest part2
  (testing "part02"
    (is (= 4
           (day04/part02 input)))))
