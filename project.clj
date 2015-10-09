(defproject goog-define-bug "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.122"]]
  :source-paths ["src/cljs"]
  :plugins [[lein-cljsbuild "1.0.6"]]
  :hooks [leiningen.cljsbuild]
  :min-lein-version "2.0.0"
  :cljsbuild {:builds #=(eval (into []
                            (for [opt [:none :simple :whitespace :advanced]]
                              {:compiler
                               {:output-dir (str "resources/public/js/" (name opt))
                                :output-to (str "resources/public/js/" (name opt) ".js")
                                :optimizations opt
                                :closure-defines {'goog-define-bug.core/opt-type (name opt)}}
                                :id (name opt)
                                :source-paths ["src"]})))})
