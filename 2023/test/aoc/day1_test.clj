(ns aoc.day1-test
  (:require [clojure.test :refer :all]
            [aoc.day1 :as day1]))

(def input-1
  ["1abc2"
   "pqr3stu8vwx"
   "a1b2c3d4e5f"
   "treb7uchet"])

(deftest solve-part1
  (testing "part 1"
    (is (= 142 (day1/solve-part1 input-1)))))

(def input-2
  ["two1nine"
   "eightwothree"
   "abcone2threexyz"
   "xtwone3four"
   "4nineeightseven2"
   "zoneight234"
   "7pqrstsixteen"])

(deftest solve-part2
  (testing "part 2"
    (is (= 281 (day1/solve-part2 input-2)))
    (is (= 28 (day1/solve-part2 ["2fourseven1oneights"])))))
