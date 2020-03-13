package com.algorithms.hackerrank.arrays;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortDecimalsAsStrings {


    public static void main(String[] args) {

        /*
        Check this:
        Arrays.sort(s, 0, n, (a, b) -> new BigDecimal(b).compareTo(new BigDecimal(a)));
         */

        String [] s = {"-100", "00.12", ".12", "02.340"};

        // (str1, str2) -> {} is lambda, replacing:
        // new Comparator<String>() {
        //    @Override
        //    public int compare(String a1, String a2) {}
        Arrays.sort(s, Collections.reverseOrder((str1, str2) -> {

            BigDecimal bigD1 = new BigDecimal(str1);
            BigDecimal bigD2 = new BigDecimal(str2);

            return bigD1.compareTo(bigD2);
        }));

        for (String str : s) {
            System.out.println(str);
        }

    }
    


}
