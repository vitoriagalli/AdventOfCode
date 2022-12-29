(ns aoc.day05
  (:require [clojure.string :as str]))

(def regex #"move (\d+) from (\d+) to (\d+)")

(defn add-crate-on-stack
  [crates stacks index]
  (let [crate     (get crates index)
        key-index (-> index
                      (/ 4)
                      int
                      inc
                      str
                      keyword)]
    (if (and (some? crate)
             (not= crate \space))
      (update-in stacks [key-index] conj (get crates index))
      stacks)))

(defn organize-stacks
  [indexes stacks-map crates]
  (reduce (partial add-crate-on-stack crates) stacks-map indexes))

(defn parsed-stacks
  [stack-lines]
  (let [indexes-line (last stack-lines)
        indexes      (->> indexes-line
                          seq
                          (map #(when (not (= % \space)) (str/index-of indexes-line %)))
                          (keep identity))
        stacks-lines (->> stack-lines reverse rest)]
    (reduce (partial organize-stacks indexes) {} stacks-lines)))

(defn parsed-instruction
  [instruction]
  (let [[_ n from to] (re-matches regex instruction)]
    {:n    (Integer/parseInt n)
     :from (keyword from)
     :to   (keyword to)}))

(defn move-single-crater
  [{:keys [from to]} stacks _]
  (let [next-in-stack (peek (from stacks))]
    (if (some? next-in-stack)
      (assoc stacks from (pop (from stacks))
                    to (conj (to stacks) next-in-stack))
      stacks)))

(defn one-at-a-time
  [stacks {:keys [n] :as instruction}]
  (reduce (partial move-single-crater instruction) stacks (range n)))

(defn by-block
  [stacks {:keys [n from to]}]
  (-> stacks
      (assoc-in [from] (drop n (from stacks)))
      (update-in [to] into (reverse (take n (from stacks))))))

(defn rearrange-stack
  [fn-move-crates input]
  (let [lines-with-stack        (take-while #(not (empty? %)) input)
        initial-stacks          (parsed-stacks lines-with-stack)
        lines-with-instructions (drop (inc (count lines-with-stack)) input)
        instructions            (map #(parsed-instruction %) lines-with-instructions)
        final-stack             (reduce fn-move-crates initial-stacks instructions)]
    (->> final-stack
         (into (sorted-map))
         (map #(first (val %)))
         (apply str))))

(defn part01
  [input]
  (rearrange-stack one-at-a-time input))

(defn part02
  [input]
  (rearrange-stack by-block input))

(def solver
  {:day 5
   :fn1 part01
   :fn2 part02})
