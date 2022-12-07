(ns aoc.day6)

(defn repeated-char?
  [groups-of processed-chars]
  (or (< (count processed-chars) groups-of)
      (not (apply distinct? (take groups-of (reverse processed-chars))))))

(defn check-repeated-char
  [groups-of processed-chars char]
  (let [updated-processed-chars (conj processed-chars char)]
    (if (repeated-char? groups-of updated-processed-chars)
      updated-processed-chars
      (reduced (count updated-processed-chars)))))

(defn processed-chars-by-groups-of
  [groups-of input]
  (reduce (partial check-repeated-char groups-of) [] (-> input first vec)))

(defn part01
  [input]
  (processed-chars-by-groups-of 4 input))

(defn part02
  [input]
  (processed-chars-by-groups-of 14 input))

(def solver
  {:day 6
   :fn1 part01
   :fn2 part02})
