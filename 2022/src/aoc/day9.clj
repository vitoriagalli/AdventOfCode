(ns aoc.day9
  (:require [clojure.string :as str]))

(defn abs
  [n]
  (if (neg? n) (* -1 n) n))

(defn parsed-input
  [line]
  (let [[key value] (str/split line #" ")
        steps (Integer/parseInt value)]
    (->> (case key
           "R" [1 0]
           "L" [-1 0]
           "U" [0 1]
           "D" [0 -1])
         (repeat steps))))

(defn move-rope?
  [[x-head y-head]
   [x-tail y-tail]
   knots]
  (some #(> % knots) [(abs (- x-head x-tail))
                      (abs (- y-head y-tail))]))

(defn inc-rope-move
  [knots
   {[x-head y-head] :head
    tails           :tails}
   [xm ym]]
  (let [[x-up y-up :as head-updated] [(+ x-head xm) (+ y-head ym)]]
    {:head  head-updated
     :tails (if (move-rope? head-updated (last tails) knots)
              (conj tails [(- x-up xm) (- y-up ym)])
              tails)}))


(defn move-rope-to-direction
  [knots state move-list]
  (reduce (partial inc-rope-move knots) state move-list))

(defn tail-positions-by-knot-rope
  [input knots]
  (let [moves         (mapv parsed-input input)
        initial-state {:head [0 0] :tails [[0 0]]}]
    (->> moves
         (reduce (partial move-rope-to-direction knots) initial-state)
         :tails
         println
         distinct
         count)))


(defn part01
  [input]
  (tail-positions-by-knot-rope input 1))

(defn part02
  [input]
  (tail-positions-by-knot-rope input 9))

(def solver
  {:day 9
   :fn1 part01
   :fn2 part02})
