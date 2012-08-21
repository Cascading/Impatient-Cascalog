(ns impatient.core-test
  (:use impatient.core
        clojure.test
        cascalog.api
        [midje sweet cascalog]))

(deftest scrub-text-test
  (fact
    (scrub-text "FoO BAR  ") => "foo bar"))
