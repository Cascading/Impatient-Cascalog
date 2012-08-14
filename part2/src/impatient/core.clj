(ns impatient.core
  (:use cascalog.api)
  (:require [clojure.string :as s]
            [cascalog.ops :as c])
  (:gen-class))

(defmapcatop split [line]
  "reads in a line of string and splits it by regex"
  (s/split line #"\s+"))

(defn -main [in out & args]
  (?<- (hfs-textline out)
       [?word ?count]
       ((hfs-textline in) ?line)
       (split ?line :> ?word)
       (c/count ?count)))
