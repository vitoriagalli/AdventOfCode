(ns aoc.day7
  (:require [tupelo.core :as t]))


(def list-cmd "$ ls")
(def cd-out "$ cd ..")
(def cd-in-regex #"\$ cd ([\\\/\w+])")
(def file-regex #"(\d+) ([\w\.]+)")
(def dir-regex #"dir (\w+)")

(def my-map {:1 {:4 4
                 :55 {:3 444}
                 :22 {:99 1
                      :5 5
                      :8 {:77 77
                          :43 23}}}})

; a partir da chave eu pego o valor daquela chave

(defn find-value-by-key-nested
  [dir-map key]
  (->> (tree-seq map? vals dir-map)
       (filter map?)
       (some key)))


(defn check-if-parent
  [map-to-look child-key possible-parent-key]

  (println " child key" child-key "\n"
           "possible parent" possible-parent-key "\n"
           "map to look" map-to-look)

  (let [key (as-> (possible-parent-key map-to-look) child-keys
                  (when (map? child-keys)
                    (->> child-keys
                         keys
                         (some #(= % child-key)))))]
    (if key
      (reduced possible-parent-key)
      child-key)))


(defn maybe-parent-key
  [child-key map-to-look]
  (let [possible-parent-keys (keys map-to-look)]
    ;(println "*** " map-to-look "\n" possible-parent-keys "\n" child-key)
    (reduce (partial check-if-parent map-to-look) child-key possible-parent-keys)))

; presuming my vals are different from each other
(defn find-parent-key
  [dir-map child-key]
  (->> (tree-seq map? vals dir-map)
       (filter map?)
       (reduce maybe-parent-key child-key)))


(defn add-keys
  [dir-map curr-dir key value]


  )


(defn parsed-input
  [[dir-map curr-dir] line]

  (let [[_ cd-in]     (re-matches cd-in-regex line)
        [_ size file] (re-matches file-regex line)
        [_ dir]       (re-matches dir-regex line)
        cd-out        (= cd-out line)
        list-cmd      (= list-cmd line)]
    (cond
      cd-in    [dir-map cd-in]
      cd-out   [dir-map (find-parent-key dir-map curr-dir)]
      list-cmd [dir-map curr-dir]
      file     [(add-keys dir-map curr-dir file size) curr-dir]
      dir      [dir-map curr-dir]
      )))

(defn part01
  [input]
  (-> (reduce parsed-input [{:/ [0 {}]} -1] input)
      ;println
      )
  0)



(defn part02
  [input]
  0)

(def solver
  {:day 7
   :fn1 part01
   :fn2 part02})
