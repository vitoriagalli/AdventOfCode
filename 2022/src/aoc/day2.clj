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

(defn parse-key
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

(defn match-score-1
  [line]
  (let [opponent-move (-> line :opponent opponent-move-map)
        my-move       (-> line :me my-move-map)
        my-outcome    (first (match-outcome opponent-move my-move))]
    (+ (my-outcome match-points)
       (my-move shape-points))))

(defn match-move
  [opponent-move my-outcome]
  (let [possible-outcomes (my-outcome my-outcomes-map)
        keys              (keys possible-outcomes)]
    (for [key keys
          :when (= opponent-move (key possible-outcomes))]
      key)))

(defn match-score-2
  [line]
  (let [opponent-move (-> line :opponent opponent-move-map)
        my-outcome    (-> line :me my-needed-outcome-map)
        my-move       (first (match-move opponent-move my-outcome))]
    (+ (my-outcome match-points)
       (my-move shape-points))))

(defn part01
  [input]
  (let [output-keys-list (mapv parse-key input)]
    (transduce (map #(match-score-1 %)) + output-keys-list)))

(defn part02
  [input]
  (let [output-keys-list (mapv parse-key input)]
    (transduce (map #(match-score-2 %)) + output-keys-list)))

(def solver
  {:day 2
   :fn1 part01
   :fn2 part02})
