(ns impatient.core
  (:use [cascalog.api]
        [cascalog.more-taps :only (hfs-delimited)])
  (:require [clojure.string :as s]
            [cascalog.ops :as c])
  (:gen-class))

(defmapcatop split [line]
  "reads in a line of string and splits it by regex"
  (s/split line #"[\[\]\\\(\),.)\s]+"))

(defn constant-true [x]
  "always return true"
  true)

(defn expand-stop-tuple [stop]
  (<- [?stop ?stub]
      (stop ?stop)
      (constant-true ?stop :> ?stub)))

(defn -main [in out stop & args]
  (let [rain (hfs-delimited in :skip-header? true)
        stop (expand-stop-tuple (hfs-delimited stop :skip-header? true))]
    (?<- (hfs-delimited out)
         [?word ?count]
         (rain _ ?line)
         (split ?line :> ?word-dirty)
         ((c/comp #'s/trim #'s/lower-case) ?word-dirty :> ?word)
         (stop ?word !!is-stop)
         (nil? !!is-stop)
         (c/count ?count))))
