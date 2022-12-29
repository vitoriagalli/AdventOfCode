(ns aoc.day09
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

(defn tail-updated
  [[x-head y-head]
   [x-tail y-tail]]
  (let [delta-x (- x-head x-tail)
        delta-y (- y-head y-tail)
        dir-x   (if (zero? delta-x) 0 (/ delta-x (abs delta-x)))
        dir-y   (if (zero? delta-y) 0 (/ delta-y (abs delta-y)))]
    [(+ x-tail dir-x) (+ y-tail dir-y)]))

(defn inc-rope-move
  [knots
   {[x-head y-head] :head
    tails           :tails}
   [xm ym]]
  (let [head-updated [(+ x-head xm) (+ y-head ym)]
        tail         (last tails)]
    {:head  head-updated
     :tails (if (move-rope? head-updated tail knots)
              (conj tails (tail-updated head-updated tail))
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
