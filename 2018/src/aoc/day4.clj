(ns aoc.day4
  (:require [aoc.core :as core]
            [clojure.string :as str]))

(def regex  #"\[(\d{4}\-\d{2}\-\d{2}) (\d{2})\:(\d{2})\] (.+$)")

(defn parse-info-to-key
  [info]
  (cond
    (str/includes? info "falls asleep") :fall-asleep
    (str/includes? info "wakes up") :wakes-up
    :else (-> (re-matches #"^[\w\s]+\#(\d+)[\w\s]+$" info)
              second
              Integer/parseInt)))

(defn new-shift
  [result-map
   guard
   date]

  ;(println guard date)

  (if (guard result-map)
    (update-in result-map [guard] conj {date []})
    (conj result-map {guard {date []}}))
  )

(defn parsed-line
  [[result-map guard] line]
  (let [[_ date _ minutes info] (re-matches regex line)
        key   (parse-info-to-key info)
        guard (if (int? key) (keyword (str key)) guard)
        min (Integer/parseInt minutes)]
    (case key
      :fall-asleep [(update-in result-map [guard date] conj min) guard]
      :wakes-up [(update-in result-map [guard date] conj min) guard]
      [(new-shift result-map guard date) guard])))


(defn a
  [date-info]

  (println date-info)

  0

  ;(let [vec    (vals date-info)
  ;      n-even (take-nth 0 (rest vec))
  ;      n-odd  (take-nth 0 vec)]
  ;  (- (apply + n-even)
  ;     (apply + n-odd)))
  )

(defn sleep-sum
  [[max-sum guard]
   guard-shifts]
  ;(println (second guard-shifts))
  (let [shifts-info (second guard-shifts)
        ;sum         (transduce a + shifts-info)

        ]

    (println shifts-info)

    ;(if (> sum max-sum)
    ;  [sum (key guard-shifts)]
    ;  [max-sum guard])
    )
  )

(defn part01
  [input]
  (let [guards-shifts (first (reduce parsed-line [{} :0] input))
        sum (reduce sleep-sum [0 :0] guards-shifts)

        ]
    sum))

(defn part02
  [input]
  0)

(defn solver []
  (core/solve-day 4 part01 part02))


;{:10 {:10-10-21 [0 0 0 0 1 1 1 1 1 1 0 0 0 0 0 0 0 1 1 1 1 ]}}

;{:10 {:10-10-21 []}}
