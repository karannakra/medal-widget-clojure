(ns medals.main
  (:require
   [medals.constants :refer [MEDAL_COLOR_CONSTANT ALLOWED_SORT_VALUES]]
   [re-frame.core :as re-frame]
   [medals.events :as events]
   [medals.subs :as subs]
   [medals.utils :refer [get-total-count]]))


(defn tableHeaders [color selected-sort]
  ^{:key color} [:th {:class (str "medal-colors" " "  (if (= selected-sort (:color_name color)) "selected" ""))}
                 [:span {:style {:background-color (:hex_code color)} :on-click #(re-frame/dispatch [::events/change-selected-sort (:color_name color)])}]])


(defn country-medals [{:keys [code index] :as country}]
  ^{:key code} [:tr
                [:td {:col-span 10}
                 [:div {:class "medal-widget_country-info"}
                  [:span index]
                  [:img {:alt code :width 50 :height 30 :src (str "https://countryflagsapi.com/png/" code)}]
                  [:span code]]]
                (map (fn [key] ^{:key key} [:td (get country key)]) (filter (fn [key] (contains? ALLOWED_SORT_VALUES key)) (keys country)))])

(defn get-countries-with-total [countries]
  (map (fn [country] (assoc country :total (get-total-count country))) countries))


(defn render-widget []
  (let [sort @(re-frame/subscribe [::subs/sort])
        countries (get-countries-with-total @(re-frame/subscribe [::subs/countries]))]
    [:div {:class "medal-widget__wrapper"}
     [:table {:class "medal-widget__table"}
      [:thead
       [:tr [:td "MEDAL COUNT"]]
       [:tr
        [:th {:col-span "10"}]
        (map (fn [color] (tableHeaders color sort)) MEDAL_COLOR_CONSTANT)
        [:th {:class (str (if (= sort (:total ALLOWED_SORT_VALUES)) " selected " "") " cursor-pointer")}
         [:span {:on-click #(re-frame/dispatch [::events/change-selected-sort "total"])}  "TOTAL"]]]]
      [:tbody
       (map country-medals countries)]]]))

