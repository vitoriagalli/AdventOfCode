(ns aoc.day1-test
  (:require
   [aoc.day1 :as day01]
   [clojure.test :refer :all]))

(def input ["1000"
            "2000"
            "3000"
            ""
            "4000"
            ""
            "5000"
            "6000"
            ""
            "7000"
            "8000"
            "9000"
            ""
            "10000"])

(deftest part1
  (testing "part01"
    (is (= 24000
           (day01/part01 input)))))

(deftest part2
  (testing "part02"
    (is (= 45000
           (day01/part02 input)))))
