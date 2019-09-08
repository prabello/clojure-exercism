(ns bob (:require [clojure.string :as str])

(declare asking? yelling? silence?)

(defn response-for [s]
  (cond
    (and (asking? s) (yelling? s)) "Calm down, I know what I'm doing!"
    (silence? s) "Fine. Be that way!"
    (asking? s) "Sure."
    (yelling? s) "Whoa, chill out!"
    :else "Whatever."))


(defn asking? [s]
  (str/ends-with? s "?"))

(defn yelling? [s]
  (and (= (str/upper-case s) s)
       (not= (str/lower-case s) s)))

(defn silence? [s]
  (str/blank? s))