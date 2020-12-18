(ns rna-transcription)

(def rna-global {\G "C", \C "G",
                 \T "A", \A "U"})

(defn to-rna [dna] ;; <- arglist goes here
  (apply str 
         (map (fn 
                [letter] 
                (if (contains? rna-global letter) 
                  (get rna-global letter) 
                  (throw (AssertionError. "Wrong input.")))) 
              (char-array dna))))
