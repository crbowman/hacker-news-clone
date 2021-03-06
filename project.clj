(defproject hacker-news-clone "0.1.0-SNAPSHOT"
  :description "A Hacker News clone in Clojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.logging "0.2.3"]
                 [com.datomic/datomic-free "0.9.5697"]
                 [http-kit "2.2.0"]
                 [compojure "1.6.1"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-json "0.4.0"]]
  :dev-dependencies [[ring/ring-devel "1.6.3"]]
  :plugins [[cider/cider-nrepl "0.16.0"]
            [lein-ring "0.12.4"]
            [lein-datomic "0.2.0"]]
  :ring {:handler hacker-news-clone.core/app}
  :jvm-opts [])
