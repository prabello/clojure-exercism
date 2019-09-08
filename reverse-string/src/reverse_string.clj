(ns reverse-string
  (:require [clojure.string :as str]))

(defn reverse-string [text]
  ;(reduce (fn [k v] (str v k)) (str/split text #""))
  (reduce #(str %2 %1) (str/split text #""))
)
