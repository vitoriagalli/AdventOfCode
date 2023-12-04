(ns aoc.day1
  (:require [aoc.core :as core]
            [aoc.utils :as utils]
            [clojure.string :as string]))

(def digits
  ["0" "1" "2" "3" "4" "5" "6" "7" "8" "9"])

(def numbers
  ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])

(def reverse-numbers
  (map #(apply str (reverse %)) numbers))

(defn ^:private is-digit?
  [char]
  (Character/isDigit char))

(defn ^:private number
  [line]
  (let [first-number (utils/find-first is-digit? line)
        last-number  (utils/find-first is-digit? (reverse line))]
    (Integer/parseInt (str first-number last-number))))

(defn solve-part1
  [input]
  (transduce (map number) + 0 input))

(defmethod core/part1 1
  [_day
   input]
  (solve-part1 input))

(defn ^:private split-string-by-list
  [str list]
  (re-seq (re-pattern (string/join "|" list)) str))

(defn ^:private translate-number
  [element]
  (let [position (.indexOf numbers element)]
    (if (neg? position)
      element
      position)))

(defn ^:private number-by-digit-or-word
  [line]
  (let [number-list         (split-string-by-list line (merge numbers digits))
        first-number        (translate-number (first number-list))
        reverse-number-list (split-string-by-list (apply str (reverse line)) (merge reverse-numbers digits))
        last-number         (translate-number (apply str (reverse (first reverse-number-list))))]
    (Integer/parseInt (str first-number last-number))))

(defn solve-part2
  [input]
  (transduce (map number-by-digit-or-word) + 0 input))

(defmethod core/part2 1
  [_day
   input]
  (solve-part2 input))
