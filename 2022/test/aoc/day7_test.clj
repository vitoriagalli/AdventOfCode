(ns aoc.day7-test
  (:require [aoc.day7 :as day07]
            [clojure.test :refer :all]))

(def input ["$ cd /"
            "$ ls"
            "dir a"
            "14848514 b.txt"
            "8504156 c.dat"
            "dir d"
            "$ cd a"
            "$ ls"
            "dir e"
            "29116 f"
            "2557 g"
            "62596 h.lst"
            "$ cd e"
            "$ ls"
            "584 i"
            "$ cd .."
            "$ cd .."
            "$ cd d"
            "$ ls"
            "4060174 j"
            "8033020 d.log"
            "5626152 d.ext"
            "7214296 k"])

(deftest part1
  (testing "part01"
    (is (= 95437
           (day07/part01 input)))))

(deftest part2
  (testing "part02"
    (is (= 24933642
           (day07/part02 input)))))
