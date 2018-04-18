(defproject hacker-news-clone "0.1.0-SNAPSHOT"
  :description "A Hacker News clone in Clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.2.0"]
                 [compojure "1.6.1"]
                 [ring/ring-core]]
  :dev-dependencies [[ring/ring-devel "1.6.3"]]
  :plugins [[lein-ring "0.12.4"]]
  :ring {:handler hacker-news-clone.core/app}
  :main hacker-news-clone.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
