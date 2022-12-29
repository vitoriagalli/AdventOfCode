(ns aoc.day05-test
  (:require [aoc.day05 :as day05]
            [clojure.test :refer :all]))

(def input ["    [D]"
            "[N] [C]"
            "[Z] [M] [P]"
            " 1   2   3"
            ""
            "move 1 from 2 to 1"
            "move 3 from 1 to 3"
            "move 2 from 2 to 1"
            "move 1 from 1 to 2"])

(deftest part1
  (testing "part01"
    (is (= "CMZ"
           (day05/part01 input)))))

(deftest part2
  (testing "part02"
    (is (= "MCD"
           (day05/part02 input)))))
