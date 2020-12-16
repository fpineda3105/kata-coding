(ns reverse-string)

(defn reverse-string [s] ;; <- arglist goes here
  (if (= (count s) 1)
    s
    (loop [remaining s result '()]
      (if (empty? remaining)
        (reduce str result)
        (recur (rest remaining) (conj result (first remaining))))))  
)

(defn reverse-string-refactored [s] ;; <- arglist goes here
  (apply str (into () s))
  )
