(ns aoc.day1-test
  (:require
   [aoc.day1 :as day01]
   [clojure.test :refer :all]))

(deftest day01
  (testing "part 01"
    (is (= 3
           (day01/part01 ["+1" "-2" "+3" "+1"])))
    (is (= 3
           (day01/part01 ["+1" "+1" "+1"])))
    (is (= 0
           (day01/part01 ["+1" "+1" "-2"])))
    (is (= -6
           (day01/part01 ["-1" "-2" "-3"]))))

  (testing "part 02"
    (is (= 2
           (day01/part02 ["+1" "-2" "+3" "+1"])))
    (is (= 0
           (day01/part02 ["+1" "-1"])))
    (is (= 10
           (day01/part02 ["+3" "+3" "+4" "-2" "-4"])))
    (is (= 5
           (day01/part02 ["-6" "+3" "+8" "+5" "-6"])))
    (is (= 14
           (day01/part02 ["+7" "+7" "-2" "-7" "-4"])))))
