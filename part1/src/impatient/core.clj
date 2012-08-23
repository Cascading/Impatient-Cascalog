(ns impatient.core
  (:use [cascalog.api]
        [cascalog.more-taps :only (hfs-delimited)])
  (:gen-class))

(defn -main [in out & args]
  (?<- (hfs-delimited out)
       [?doc ?line]
       ((hfs-delimited in :skip-header? true) ?doc ?line)))
