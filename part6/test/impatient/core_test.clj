(ns impatient.core-test
  (:use impatient.core
        clojure.test
        cascalog.api
        [midje sweet cascalog]))

(deftest scrub-text-test
  (fact
    (scrub-text "FoO BAR  ") => "foo bar"))

(deftest expand-stop-tuple-test
  (let [src  [["a"] ["b"] ["c"]]]
    (fact
      (expand-stop-tuple src) => (produces [["a" true] ["b" true] ["c" true]]))))

(deftest etl-docs-gen-test
  (let [rain [["doc1" "a b c"]]
        stop [["b" true]]]
    (fact
      (etl-docs-gen rain stop) => (produces [["doc1" "a"]
                                             ["doc1" "c"]]))))

(deftest uniquefy-test
  (fact
    (uniquefy [["a"] ["b"] ["a"]]) => (produces [["a"] ["b"]])))
