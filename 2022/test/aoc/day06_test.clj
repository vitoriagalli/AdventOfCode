(ns aoc.day06-test
  (:require [aoc.day06 :as day06]
            [clojure.test :refer :all]))

(deftest part1
  (testing "part01"
    (is (= 7
           (day06/part01 ["mjqjpqmgbljsphdztnvjfqwrcgsmlb"])))
    (is (= 5
           (day06/part01 ["bvwbjplbgvbhsrlpgdmjqwftvncz"])))
    (is (= 6
           (day06/part01 ["nppdvjthqldpwncqszvftbrmjlhg"])))
    (is (= 10
           (day06/part01 ["nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"])))
    (is (= 11
           (day06/part01 ["zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"])))))

(deftest part2
  (testing "part02"
    (is (= 19
           (day06/part02 ["mjqjpqmgbljsphdztnvjfqwrcgsmlb"])))
    (is (= 23
           (day06/part02 ["bvwbjplbgvbhsrlpgdmjqwftvncz"])))
    (is (= 23
           (day06/part02 ["nppdvjthqldpwncqszvftbrmjlhg"])))
    (is (= 29
           (day06/part02 ["nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"])))
    (is (= 26
           (day06/part02 ["zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"])))))
