(ns medals.events
  (:require
   [re-frame.core :as re-frame]
   [medals.db :as db]
   [ajax.core :as ajax]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced []
            db/default-db))

(re-frame/reg-event-db
 ::change-selected-sort
 (fn [db [_ selected-sort]]
   (println selected-sort)
   (assoc db :sort selected-sort)))



(re-frame/reg-event-db
 ::fetch-countries-success
 (fn [db [_ {:keys [data]}]]
   (println "inside")
   (assoc db :loading false
             :countries data)))
(re-frame/reg-event-db
 ::bad-http-result
 (fn [db []]
   (println "inside")))


(re-frame/reg-event-fx
 ::fetch-countries-data
 (fn [_world [_ val]]
   {:http-xhrio {:method :get
                 :uri "http://localhost:8080/get-medals"
                 :timeout 8000
                 :response-format (ajax/json-response-format {:keywords? true})
                 :on-success [::fetch-countries-success]
                 :on-failure [::bad-http-result]}}))





