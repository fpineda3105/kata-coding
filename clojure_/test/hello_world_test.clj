(ns hello-world-test
  (:require [clojure.test :refer :all]
            [hello-world :as hello]))

(deftest hello-test
  (testing "A simple hello"
    (is (= "Hello world" (hello/hello)))))
