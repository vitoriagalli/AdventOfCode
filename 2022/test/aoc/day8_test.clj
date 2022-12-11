(ns aoc.day8-test
  (:require [aoc.day8 :as day08]
            [clojure.test :refer :all]))

(def input ["30373"
            "25512"
            "65332"
            "33549"
            "35390"])

(deftest part1
  (testing "part01"
    (is (= 21
           (day08/part01 input)))))

(deftest part2
  (testing "part02"
    (is (= 8
           (day08/part02 input)))))
