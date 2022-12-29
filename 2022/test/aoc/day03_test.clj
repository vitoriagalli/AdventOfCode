(ns aoc.day03-test
  (:require [aoc.day03 :as day03]
            [clojure.test :refer :all]))

(def input ["vJrwpWtwJgWrhcsFMMfFFhFp"
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"
            "PmmdzqPrVvPwwTWBwg"
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"
            "ttgJtRGJQctTZtZT"
            "CrZsJsPPZsGzwwsLwLmpwMDw"])

(deftest part1
  (testing "part01"
    (is (= 157
           (day03/part01 input)))))

(deftest part2
  (testing "part02"
    (is (= 70
           (day03/part02 input)))))
