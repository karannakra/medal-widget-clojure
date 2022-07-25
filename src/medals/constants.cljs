(ns medals.constants)


(def MEDAL_COLOR_CONSTANT [{:color_name "gold" :hex_code "#FFD700"} , {:color_name "silver" :hex_code "#D3D3D3"} ,{:color_name "bronze" :hex_code "#CD7F32"}])

(def ALLOWED_SORT_VALUES {:gold "gold"
                          :silver "silver"
                          :bronze "bronze"
                          :total "total"})


(def ALLOWED_SUMMATION_VALUES {:silver  "silver"
                               :gold "gold"
                               :bronze "bronze"})

(def COUNTRIES [{:index 1
                 :code "USA"
                 :gold 9
                 :silver 7
                 :bronze 12}
                {:index 2
                 :code "NOR"
                 :gold 11
                 :silver 5
                 :bronze 10}
                {:index 3
                 :code "RUS"
                 :gold 13
                 :silver 11
                 :bronze 9}
                {:index 4
                 :code "NED"
                 :gold 8
                 :silver 7
                 :bronze 9}
                {:index 5
                 :code "FRA"
                 :gold 4
                 :silver 4
                 :bronze 7}

                {:index 6
                 :code "SWE"
                 :gold 2
                 :silver 7
                 :bronze 6}
                {:index 7
                 :code "ITA"
                 :gold 0
                 :silver 2
                 :bronze 6}
                {:index 8
                 :code "CAN"
                 :gold 10
                 :silver 10
                 :bronze 5}
                {:index 9
                 :code "SUI"
                 :gold 6
                 :silver 3
                 :bronze 2}
                {:index 10
                 :code "BLR"
                 :gold 5
                 :silver 0
                 :bronze 1}
                {:index 11
                 :code "GER"
                 :gold 8
                 :silver 6
                 :bronze 5}
                {:index 12
                 :code "AUT"
                 :gold 4
                 :silver 8
                 :bronze 5}
                {:index 13
                 :code "CHN"
                 :gold 3
                 :silver 4
                 :bronze 2}])










































