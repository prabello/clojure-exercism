(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn multiply-elements [number-vector]
  (map (fn [n] (exp n (count number-vector))) number-vector))

(defn split-digits [num]
  (map read-string (str/split (str num) #"")))

(defn armstrong? [num]
  (def resp (reduce + (multiply-elements (split-digits num))))
  (= resp num))

