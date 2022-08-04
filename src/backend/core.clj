(ns backend.core
  (:require
   [reitit.ring :as ring]
   [muuntaja.core :as m]
   [clojure.data.json :as json]
   [aleph.http :as http]
   [mount.core :as mount]
   [reitit.ring.middleware.muuntaja :as muuntaja]))


(def medals-data (atom (json/read-str (slurp "src/backend/medals.json") :key-fn keyword)))

(defn get-medals-handler [_]
  {:status 200
   :body @medals-data
   :headers {:access-control-allow-origin *}})

(def app
  (ring/ring-handler
   (ring/router
    ["/get-medals" get-medals-handler]
    {:data {:muuntaja m/instance
            :middleware [muuntaja/format-middleware]}})))

(mount/defstate server
  :start (http/start-server #'app {:port 8080})
  :stop (.stop server))


(defn -main [& _]
  (mount/start))




