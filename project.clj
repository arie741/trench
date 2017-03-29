(defproject trench "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [clj-postgresql "0.4.0"]
                 [enlive "1.1.6"]
                 [hiccup "1.0.5"]
                 [lib-noir "0.9.9"]
                 [clojurewerkz/scrypt "1.2.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler trench.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
