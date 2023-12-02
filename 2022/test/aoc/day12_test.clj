(ns aoc.day12-test
  (:require [aoc.day12 :as day12]
            [clojure.test :refer :all]))

(def input ["Sabqponm"
            "abcryxxl"
            "accszExk"
            "acctuvwj"
            "abdefghi"])

(deftest part1
  (testing "part01"
    (is (= 31
           (day12/part01 input)))))

(deftest part2
  (testing "part02"
    (is (= -1
           (day12/part02 input)))))

; nao repetir nenhuma posicao
; se chegar no fim, voltar pro incio e comecar de novo
; se nao tiver nenhuma outra posicao disponivel, voltar pra anterior
; quando chegar no inicio de novo, termina!
