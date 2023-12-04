(ns aoc.utils-test
  (:require [clojure.test :refer :all]
            [aoc.utils :as utils]))

(deftest find-first
  (testing "it should return the first occurrence of an element that satisfies the predicate"
    (are [expected-result pred coll]
      (is (= expected-result
             (utils/find-first pred coll)))
      2 even? [1 2 3 4 5 6 7 8 9 10]
      33 int? [1M "loren" 33 6M 88])))
