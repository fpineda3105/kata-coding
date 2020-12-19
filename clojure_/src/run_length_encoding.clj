(ns run-length-encoding)

; encoding

(defn encode-letters
  "encodes a secuence of letters in a code. eg ('A' 'A' 'A' 'A' 'A') -> '5A',  ('A') -> A"
  [group-letters]
  (str
   (if (> (count group-letters) 1)
     (str (count group-letters))
     "")
   (str (first group-letters))))

(defn group-codes-letters
  "returns a secuence of letters code in form {Number-Letter} e.g AAABBBB -> ('3A' '4B')"
  [plain-text]
  (map (fn [group-letters]
         (encode-letters group-letters))
       (partition-by identity plain-text)))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (if (<= (count plain-text) 1)
    plain-text
    (apply str (group-codes-letters plain-text))))


; decoding
(defn- extract-frequencies
  "return the frequencies of a code. e.g 12A -> 12, B -> 0"
  [code]
  (let [number (re-find #"^\d+" code)]
    (if (nil? number)
      0
      (Integer/parseInt number))))

(defn- extract-letter
  "return the letter of a code. e.g 12A -> A, B -> B"
  [code] (re-find  #"[^\d+].*" code))

(defn decode-single
  "Decodes a single code in normal form. e.g 3A -> 'AAA', 4C -> 'CCCC'"
  [code]
  (let [frequencies (extract-frequencies code)
        letter (extract-letter code)]
    (if (> frequencies 0)
      (apply str (repeat frequencies letter))
      (str letter))))

(defn group-codes
  "generates a sequence of codes with the pattern {Number-Letter} eg ('12A' 'B' '2 ')"
  [cipher-text]
  (re-seq #"\d*[\D]" cipher-text))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (apply str (map decode-single (group-codes cipher-text))))
