(ns aoc.day9-test
  (:require [aoc.day9 :as day09]
            [clojure.test :refer :all]))

(def input ["R 4"
            "U 4"
            "L 3"
            "D 1"
            "R 4"
            "D 1"
            "L 5"
            "R 2"])

(deftest part1
  (testing "part01"
    (is (= 13
           (day09/part01 input)))))

(deftest part2
  (testing "part02"
    (is (= 1
           (day09/part02 input)))
    (is (= 36
           (day09/part02 ["R 5"
                          "U 8"
                          "L 8"
                          "D 3"
                          "R 17"
                          "D 10"
                          "L 25"
                          "U 20"])))))
