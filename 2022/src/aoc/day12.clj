(ns aoc.day12
  (:require [clojure.string :as str])
  (:import [clojure.lang PersistentQueue]))

(defn new-queue
  []
  (PersistentQueue/EMPTY))

(defn find-first
  [f coll]
  (first (filter f coll)))

(defn parsed-matrix
  [input]
  (mapcat identity
          (map-indexed (fn [y line]
                         (->> line
                              seq
                              (map-indexed (fn [x char]
                                             {:x      x
                                              :y      y
                                              :height (int char)}))))
                       input)))

(defn coord
  [matrix value]
  (find-first #(= value (:height %)) matrix))

(defn move
  [start
   end
   matrix
   path

   _]

  (let [current-coord (peek path)

        ]

    (println (.contains path end)))






  (reduced (count path)))

(defn part01
  [input]
  (let [matrix (parsed-matrix input)
        start  (coord matrix (int \S))
        end    (coord matrix (int \E))]
    (reduce (partial move start end matrix) (conj (PersistentQueue/EMPTY) start) (range 1))))

(defn part02
  [input]
  1)

(def solver
  {:day 12
   :fn1 part01
   :fn2 part02})
