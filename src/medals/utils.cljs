(ns medals.utils
  (:require [reagent.core :as r]
            [medals.constants :refer [ALLOWED_SUMMATION_VALUES]]))


(defn get-total-count [country]
  (def filtered-count (r/atom []))
  (for [item (keys country)]
    (when (contains? ALLOWED_SUMMATION_VALUES item)
      (println  filtered-count (get country key)))))






