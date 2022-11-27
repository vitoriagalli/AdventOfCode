(ns aoc.day2-test
  (:require
   [aoc.day2 :as day02]
   [clojure.test :refer :all]))

(deftest day02
  (testing "part 01"
    (is (= 12
           (day02/part01 ["abcdef",
                          "bababc",
                          "abbcde",
                          "abcccd",
                          "aabcdd",
                          "abcdee",
                          "ababab"]))))

  (testing "part 02"
    (is (= "fgij"
           (day02/part02 ["abcde",
                          "fghij",
                          "klmno",
                          "pqrst",
                          "fguij",
                          "axcye",
                          "wvxyz"])))))


