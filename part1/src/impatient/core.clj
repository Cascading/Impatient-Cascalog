(ns impatient.core
  (:use cascalog.api)
  (:gen-class))

(defn -main [in out & args]
  (?<- (hfs-textline out)
       [?line]
       ((hfs-textline in) ?line)))
