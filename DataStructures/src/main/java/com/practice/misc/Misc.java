package com.practice.misc;

public class Misc {

    public static void main(String[] args) {

        String str = "SELECT ch, ci FROM tenant_tag_data_points_intervals WHERE cd= :tnt AND cf " +
                "= :thsh AND cg = :ibkt AND ch >= :intvl_start AND ch <= :intvl_end  LIMIT 1000";

        String str1 = "A word 1000";

        // Try not to do it but just in case you have to :)
        System.out.println(str1.substring(str1.indexOf("1000"), str1.indexOf("1000") + 4));


    }

}
