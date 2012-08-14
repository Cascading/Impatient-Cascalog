(ns impatient.core
  (:use cascalog.api)
  (:require [clojure.string :as s]
            [cascalog.ops :as c])
  (:gen-class))

(defmapcatop split [line]
  "reads in a line of string and splits it by regex"
  (s/split #"\s+" line))

(defn scrub-text [s]
  "trim open whitespaces and lower case"
  (-> s
    (s/trim)
    (s/lower-case)))

(defn -main [in out & args]
  (?<- (hfs-textline out)
       [?word ?count]
       ((hfs-textline in) ?line)
       (split ?line :> ?word-dirty)
       (scrub-text ?word-dirty :> ?word)
       (c/count ?count)))
