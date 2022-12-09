(ns aoc.day7)

(def list-cmd "$ ls")
(def cd-out "$ cd ..")
(def cd-in-regex #"\$ cd ([\\\/\w]+)")
(def file-regex #"(\d+) ([\w\.]+)")
(def dir-regex #"dir (\w+)")

(def total-size-of-at-most 100000)

(def filesystem 70000000)
(def unused-space-of-at-least 30000000)

(defn parsed-input
  [[dir-map path-vec] line]
  (let [[_ cd-in]      (re-matches cd-in-regex line)
        [_ size file]  (re-matches file-regex line)
        [_ dir]        (re-matches dir-regex line)
        cd-out?        (= cd-out line)
        list-cmd?      (= list-cmd line)]
    (cond
      cd-in     [dir-map (vec (conj path-vec cd-in))]
      cd-out?   [dir-map (vec (drop-last path-vec))]
      list-cmd? [dir-map path-vec]
      file      [(update-in dir-map path-vec conj {file (Integer/parseInt size)}) path-vec]
      dir       [(update-in dir-map path-vec conj {dir {}}) path-vec])))

(defn sum-vals
  [map-vals]
  (when (map? map-vals)
    (->> map-vals
         (tree-seq map? vals)
         (filter #(not (map? %)))
         (apply +))))

(defn subdir-for-key
  [sum-vec dir-content]
  (conj sum-vec (sum-vals dir-content)))

(defn dir-sizes
  [input]
  (let [[file-system _] (reduce parsed-input [{"/" {}} []] input)]
    (->> (get file-system "/")
         (tree-seq map? vals)
         (filter map?)
         (reduce subdir-for-key []))))

(defn part01
  [input]
  (->> input
       dir-sizes
       (filter #(< % total-size-of-at-most))
       (reduce +)))

(defn part02
  [input]
  (let [dir-sizes-vec         (dir-sizes input)
        used-space-amount     (apply max dir-sizes-vec)
        curr-unused-space     (- filesystem used-space-amount)
        need-to-free-at-least (- unused-space-of-at-least curr-unused-space)]
    (->> dir-sizes-vec
         (filter #(> % need-to-free-at-least))
         (apply min))))

(def solver
  {:day 7
   :fn1 part01
   :fn2 part02})
