(ns impatient.core
  (:use [cascalog.api]
        [cascalog.more-taps :only (hfs-delimited)])
  (:require [clojure.string :as s]
            [cascalog [ops :as c] [vars :as v]])
  (:gen-class))

(defmapcatop split [line]
  "reads in a line of string and splits it by regex"
  (s/split line #"[\[\]\\\(\),.)\s]+"))

(defn constant-true [x]
  "always return true"
  true)

(defn expand-stop-tuple [stop]
  "hack to make 'left-join-negate-right' works in etl-docs-gen"
  (<- [?stop ?stub]
      (stop ?stop)
      (constant-true ?stop :> ?stub)))

(defn etl-docs-gen [rain stop]
  (<- [?doc-id ?word]
      (rain ?doc-id ?line)
      (split ?line :> ?word-dirty)
      ((c/comp s/trim s/lower-case) ?word-dirty :> ?word)
      (stop ?word !!is-stop)
      (nil? !!is-stop)))

(defn word-count [src]
  "simple word count across all documents"
  (<- [?word ?count]
      (src _ ?word)
      (c/count ?count)))

(defn uniquefy [src]
  "a helper function to DISTINCT the incoming source"
  (let [vars (v/gen-non-nullable-vars (num-out-fields src))]
    (<- vars
        (src :>> vars)
        (:distinct true))))

(defn D [src]
  (let [distinct-doc-id (uniquefy (select-fields src ["?doc-id"]))]
    (<- [?n-docs]
        (distinct-doc-id ?doc-id)
        (c/count ?n-docs))))

(defn DF [src]
  (let [distincted (uniquefy src)]
    (<- [?df-word ?df-count]
        (distincted _ ?df-word)
        (c/count ?df-count))))

(defn TF [src]
  (<- [?doc-id ?tf-word ?tf-count]
      (src ?doc-id ?tf-word)
      (c/count ?tf-count)))

(defn tf-idf-formula [tf-count df-count n-docs]
  (->> (+ 1.0 df-count)
    (div n-docs)
    (Math/log)
    (* tf-count)))

(defn TF-IDF [src]
  (let [n-doc (first (flatten (??- (D src))))]
    (<- [?doc-id ?tf-idf ?tf-word]
        ((TF src) ?doc-id ?tf-word ?tf-count)
        ((DF src) ?tf-word ?df-count)
        (tf-idf-formula ?tf-count ?df-count n-doc :> ?tf-idf))))

(defn -main [in out stop tfidf & args]
  (let [rain (hfs-delimited in :skip-header? true)
        stop (expand-stop-tuple (hfs-delimited stop :skip-header? true))
        src  (etl-docs-gen rain stop)]
    (?- (hfs-delimited tfidf)
        (TF-IDF src))
    (?- (hfs-delimited out)
        (word-count src))))
