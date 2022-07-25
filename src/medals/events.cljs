(ns medals.events
  (:require
   [re-frame.core :as re-frame]
   [medals.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   [medals.constants :refer [COUNTRIES]]))

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
 ::fetch-countries
 (fn [db [_]]
   (let [countries COUNTRIES]
     (assoc db :countries countries))))





