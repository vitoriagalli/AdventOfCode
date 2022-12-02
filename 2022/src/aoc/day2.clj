(ns aoc.day2)

(def outcomes-part1
  {:AX {:score 3 :shape 1}
   :AY {:score 6 :shape 2}
   :AZ {:score 0 :shape 3}
   :BX {:score 0 :shape 1}
   :BY {:score 3 :shape 2}
   :BZ {:score 6 :shape 3}
   :CX {:score 6 :shape 1}
   :CY {:score 0 :shape 2}
   :CZ {:score 3 :shape 3}})

(def outcomes-part2
  {:AX {:score 0 :shape 3}
   :AY {:score 3 :shape 1}
   :AZ {:score 6 :shape 2}
   :BX {:score 0 :shape 1}
   :BY {:score 3 :shape 2}
   :BZ {:score 6 :shape 3}
   :CX {:score 0 :shape 2}
   :CY {:score 3 :shape 3}
   :CZ {:score 6 :shape 1}})

(defn parse-key
  [line]
  (-> line
      (clojure.string/replace #" " "")
      keyword))

(defn sum-scores
  [key outcomes]
  (let [match (-> outcomes key)]
    (+ (:score match)
       (:shape match))))

(defn part01
  [input]
  (let [output-keys-list (transduce (map #(parse-key %)) conj [] input)]
    (apply + (map #(sum-scores % outcomes-part1) output-keys-list))))

(defn part02
  [input]
  (let [output-keys-list (transduce (map #(parse-key %)) conj [] input)]
    (apply + (map #(sum-scores % outcomes-part2) output-keys-list))))

(def solver
  {:day 2
   :fn1 part01
   :fn2 part02})

