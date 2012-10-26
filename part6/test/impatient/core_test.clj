(ns impatient.core-test
  (:use impatient.core
        clojure.test
        cascalog.api
        [midje sweet cascalog]))

(deftest scrub-text-test
  (fact
    (scrub-text "FoO BAR  ") => "foo bar"))

(deftest etl-docs-gen-test
  (let [rain [["doc1" "a b c"]]
        stop [["b"]]]
    (fact
      (etl-docs-gen rain stop) => (produces [["doc1" "a"]
                                             ["doc1" "c"]]))))
