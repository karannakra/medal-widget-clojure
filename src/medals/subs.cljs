(ns medals.subs
  (:require
   [re-frame.core :as re-frame]))


(re-frame/reg-sub
 ::sort
 (fn [db]
   (:sort db)))

(re-frame/reg-sub
 ::countries
 (fn [db]
   (:countries db)))
