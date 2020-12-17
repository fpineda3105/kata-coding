(ns armstrong-numbers
  (:require [clojure.string :as str]))

(defn armstrong? [num] ;; <- arglist goes here
  (let [digits (str num) count-digits (count digits)]    
    (== num
       (reduce +
               (map #(Math/pow (Integer/parseInt %) count-digits)
                    (str/split digits #""))))))


