(ns clojure-app-bench.core
  (:require
    [taoensso.carmine :as car :refer (wcar)])
  (:use org.httpkit.server)
  (:gen-class))


(def redis-conn {:pool {} :spec {:uri "redis://redis"}})
(defmacro wcar* [& body] `(car/wcar redis-conn ~@body))


(defn async-handler [ring-request]
  (with-channel ring-request channel
    (send! channel {:status 200
                    :headers {"Content-Type" "text/plain"}
                    :body    (str "Hello!" (wcar* (car/incr "counter")))})))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (run-server async-handler {:port 80})) ; Ring server
