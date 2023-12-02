(ns aoc.day4-test
  (:require [aoc.day4 :as day04]
            [clojure.test :refer :all]))

(deftest day03
  (testing "part 01"
    (is (= 240
           (day04/part01 ["[1518-11-01 00:00] Guard #10 begins shift"
                          "[1518-11-01 00:05] falls asleep"
                          "[1518-11-01 00:25] wakes up"
                          "[1518-11-01 00:30] falls asleep"
                          "[1518-11-01 00:55] wakes up"
                          "[1518-11-01 23:58] Guard #99 begins shift"
                          "[1518-11-02 00:40] falls asleep"
                          "[1518-11-02 00:50] wakes up"
                          "[1518-11-03 00:05] Guard #10 begins shift"
                          "[1518-11-03 00:24] falls asleep"
                          "[1518-11-03 00:29] wakes up"
                          "[1518-11-04 00:02] Guard #99 begins shift"
                          "[1518-11-04 00:36] falls asleep"
                          "[1518-11-04 00:46] wakes up"
                          "[1518-11-05 00:03] Guard #99 begins shift"
                          "[1518-11-05 00:45] falls asleep"
                          "[1518-11-05 00:55] wakes up"]))))
  #_(testing "part 02"
    (is (= 3
           (day04/part02 ["#1 @ 1,3: 4x4"
                          "#2 @ 3,1: 4x4"
                          "#3 @ 5,5: 2x2"])))))

