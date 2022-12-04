(ns aoc.day4)

(def regex #"(\d+)-(\d+),(\d+)-(\d+)")

(defn parsed-line
  [line]
  (let [[_ x0 xn y0 yn] (re-matches regex line)]
    {:x0 (Integer/parseInt x0)
     :xn (Integer/parseInt xn)
     :y0 (Integer/parseInt y0)
     :yn (Integer/parseInt yn)}))

(defn fully-contains?
  [{:keys [x0 xn y0 yn]}]
  (let [dot-product (* (- xn yn) (- x0 y0))]
    (or (neg-int? dot-product)
        (zero? dot-product))))

(defn overlaps?
  [{:keys [x0 xn y0 yn]}]
  (not (or (< xn y0)
           (< yn x0))))

(defn count-ranges-of-condition
  [fn-condition
   input]
  (let [sections-limits (map #(parsed-line %) input)]
    (->> sections-limits
         (map #(fn-condition %))
         (filter identity)
         count)))

(defn part01
  [input]
  (count-ranges-of-condition fully-contains? input))

(defn part02
  [input]
  (count-ranges-of-condition overlaps? input))

(def solver
  {:day 4
   :fn1 part01
   :fn2 part02})
