(defproject clojure-app-bench "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [http-kit "2.3.0"]
                 [com.taoensso/carmine "2.19.1"]]
  :main ^:skip-aot clojure-app-bench.core
  :target-path "target/%s"

  :plugins [[io.taylorwood/lein-native-image "0.3.0"]]    ;; or in ~/.lein/profiles.clj

  :native-image {:name "clojure-app-bench"                 ;; name of output image, optional
                ;  :graal-bin "/path/to/graalvm/" ;; path to GraalVM home, optional
                 :opts ["--verbose"]}           ;; pass-thru args to GraalVM native-image, optional
  :profiles {:test    ;; e.g. lein with-profile +test native-image
             {:native-image {:opts ["--report-unsupported-elements-at-runtime"
                                    "--verbose"]}}

             :uberjar ;; used by default
             {:aot :all
              :native-image {:opts ["-Dclojure.compiler.direct-linking=true"]}}})
