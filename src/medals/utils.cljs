(ns medals.utils
  (:require [reagent.core :as r]
            [medals.constants :refer [ALLOWED_SUMMATION_VALUES]]))

(defn get-total-count [country]
  (reduce (fn [total summation-key]
            (+ total (get country summation-key))) 
           0 ALLOWED_SUMMATION_VALUES)

(defn sort-countries [countries,sort-by]
  (sort (fn [countryA countryB] (cond
                                  (> (get countryA sort-by) (get countryB sort-by)) -1
                                  (< (get countryA sort-by) (get countryB sort-by)) 1
                                  :else (case sort-by
                                          :total (if (> (:gold countryA) (:gold countryB)) -1 1)
                                          :gold (if (>  (:silver countryA) (:silver countryB)) -1 1)
                                          :silver (if (> (:gold countryA) (:gold countryB)) -1 1)
                                          :bronze (if (> (:gold countryA) (:gold countryB)) -1 1)))) countries))

(defn get-countries-with-total [countries]
  (map (fn [country] (assoc country :total (get-total-count country))) countries))










