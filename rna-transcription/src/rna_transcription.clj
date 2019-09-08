(ns rna-transcription)
(declare nucleo-trans)

(defn to-rna
  [dna]
  (apply str (map nucleo-trans (seq dna))))

(defn nucleo-trans
  "Takes a char and transform giving the nucleotide rule"
  [letter]
  (println letter)
  (case (char letter)
    \G "C"
    \C "G"
    \T "A"
    \A "U"
    (throw (AssertionError. "my exception message"))))

;ACG TGG TCT TAA
;UGC ACC AGA AUU