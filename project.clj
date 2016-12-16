(defproject isomorphic-node "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :min-lein-version "2.5.3"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.293"]
                 [reagent "0.6.0"]
                 [secretary "1.2.3"]
                 [kibu/pushy "0.3.6"]]

  :plugins [[lein-cljsbuild "1.1.5"]
            [lein-figwheel "0.5.4-7"]]


  :clean-targets ^{:protect false} ["resources"]

  :profiles {:dev
             {:dependencies [[com.cemerick/piggieback "0.2.1"]
                             [org.clojure/core.async "0.2.395"]
                             [figwheel-sidecar "0.5.4-7"
                              :exclusions [org.clojure/core.async]]]
              :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}

  :cljsbuild {:builds [{:id "app"
                        :figwheel true
                        :source-paths ["src" "src-client"]
                        :compiler {
                                   :output-to "resources/public/js/app.js"
                                   :output-dir "resources/public/js"
                                   :optimizations :none
                                   :source-map true}}
                       {:id "server"
                        :figwheel true
                        :source-paths ["src" "src-server"]
                        :compiler {
                                   :main isomorphic-node.server
                                   :output-to "resources/public/js/server-side/server.js"
                                   :output-dir "resources/public/js/server-side"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true}}]})
