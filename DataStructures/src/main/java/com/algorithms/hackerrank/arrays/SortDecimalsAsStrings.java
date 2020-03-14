package com.algorithms.hackerrank.arrays;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

/*
How would you sort an array of strings containing decimal values while preserving the decimal places
including leading or trailing zeros. Also preserving leading zeros before the decimal place.

Example:
Input: {"-100", "00.12", ".12", "02.340"}
Output: {"02.340", "00.12", ".12", "-100"}


Note: We can convert the string array to BigDecimal array (since BigDecimal preserves decimal precision) by:
new BigDecimal(string) for individual elements, but the catch there will be when we convert BigDecimal back to
string, we lose the leading zeros before decimal, like "00.12" when converted to BigDecimal and back to string,
it will become "0.12", which is not what we want.

Hence, the solution in this case is to go for Arrays.sort with string array itself and provide a comparator there
which uses BigDecimal to compare the strings.

 */

public class SortDecimalsAsStrings {

    public static void main(String[] args) {

        /*
        Check this:
        Arrays.sort(s, 0, n, (a, b) -> new BigDecimal(b).compareTo(new BigDecimal(a)));
         */

        String[] s = {"-100", "00.12", ".12", "02.340"};

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
