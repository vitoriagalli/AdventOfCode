(ns aoc.day2)

(def shape-points
  {:rock     1
   :paper    2
   :scissors 3})

(def match-points
  {:loose 0
   :draw  3
   :win   6})

(def my-move-map
  {"X" :rock
   "Y" :paper
   "Z" :scissors})

(def my-needed-outcome-map
  {"X" :loose
   "Y" :draw
   "Z" :win})

(def opponent-move-map
  {"A" :rock
   "B" :paper
   "C" :scissors})

(def my-outcomes-map
  {:loose {:rock     :paper
           :paper    :scissors
           :scissors :rock}
   :draw  {:rock     :rock
           :paper    :paper
           :scissors :scissors}
   :win   {:paper    :rock
           :scissors :paper
           :rock     :scissors}})

(defn parsed-key
  [line]
  (let [vec (clojure.string/split line #" ")]
    {:opponent (first vec)
     :me       (last vec)}))

(defn match-outcome
  [opponent-move my-move]
  (for [possible-outcome my-outcomes-map
        :let [possible-opponent-move (my-move (val possible-outcome))]
        :when (= opponent-move possible-opponent-move)]
    (key possible-outcome)))

(defn match-move
  [opponent-move my-outcome]
  (let [possible-outcomes (my-outcome my-outcomes-map)
        keys              (keys possible-outcomes)]
    (for [key keys
          :when (= opponent-move (key possible-outcomes))]
      key)))

(defn match-score-by-move
  [match]
  (let [opponent-move (-> match :opponent opponent-move-map)
        my-move       (-> match :me my-move-map)
        my-outcome    (first (match-outcome opponent-move my-move))]
    (+ (my-outcome match-points)
       (my-move shape-points))))

(defn match-score-by-outcome
  [match]
  (let [opponent-move (-> match :opponent opponent-move-map)
        my-outcome    (-> match :me my-needed-outcome-map)
        my-move       (first (match-move opponent-move my-outcome))]
    (+ (my-outcome match-points)
       (my-move shape-points))))

(defn total-score
  [fn-condition input]
  (let [output-keys-list (mapv parsed-key input)]
    (transduce (map #(fn-condition %)) + output-keys-list)))

(defn part01
  [input]
  (total-score match-score-by-move input))

(defn part02
  [input]
  (total-score match-score-by-outcome input))

(def solver
  {:day 2
   :fn1 part01
   :fn2 part02})
