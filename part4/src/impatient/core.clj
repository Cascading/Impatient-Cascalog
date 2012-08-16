(ns impatient.core
  (:use [cascalog.api]
        [cascalog.more-taps :only (hfs-delimited)])
  (:require [clojure.string :as s]
            [cascalog.ops :as c])
  (:gen-class))

(defmapcatop split [line]
  "reads in a line of string and splits it by regex"
  (s/split line #"[\[\]\\\(\),.)\s]+"))

(defn scrub-text [s]
  "trim open whitespaces and lower case"
  (-> s
    (s/trim)
    (s/lower-case)))

(defmapop widen [x]
  [x true])

(defn expand-stop-tuple [dir]
  (<- [?word ?stub]
      ((hfs-textline dir) ?stop)
      (widen ?stop :> ?word ?stub)))

(defn -main [in out stop & args]
  (?<- (hfs-delimited out)
       [?word ?count]
       ((hfs-delimited in) _ ?line)
       (split ?line :> ?word-dirty)
       (scrub-text ?word-dirty :> ?word)
       ((expand-stop-tuple stop) ?word !!is-stop)
       (nil? !!is-stop)
       (c/count ?count)))
