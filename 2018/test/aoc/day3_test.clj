(ns aoc.day3-test
  (:require [aoc.day3 :as day03]
            [clojure.test :refer :all]))

(deftest day03
  (testing "part 01"
    (is (= 4
           (day03/part01 ["#1 @ 1,3: 4x4"
                          "#2 @ 3,1: 4x4"
                          "#3 @ 5,5: 2x2"]))))
  (testing "part 02"
    (is (= 3
           (day03/part02 ["#1 @ 1,3: 4x4"
                          "#2 @ 3,1: 4x4"
                          "#3 @ 5,5: 2x2"])))))
