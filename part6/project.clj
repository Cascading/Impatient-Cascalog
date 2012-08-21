(defproject impatient "0.1.0-SNAPSHOT"
  :description "Cascalog for the Impatient - Part 5"
  :url "https://github.com/Quantisan/Impatient/tree/cascalog/part5"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :uberjar-name "impatient.jar"
  :aot [impatient.core]
  :main impatient.core
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [cascalog "1.10.0"]
                 [cascalog-more-taps "0.3.0"]
                 [org.apache.hadoop/hadoop-core "0.20.2-dev"]]
  :profiles {:dev {:dependencies [[midje-cascalog "0.4.0"]]}})
