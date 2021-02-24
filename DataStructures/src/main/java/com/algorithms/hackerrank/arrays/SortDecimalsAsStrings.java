package com.algorithms.hackerrank.arrays;

import java.util.Arrays;

/**
 How would you sort an array of strings containing decimal values while preserving the decimal places
 including leading or trailing zeros. Also preserving leading zeros before the decimal place.
 Example:
 Input: {"-100", "00.12", ".12", "02.340"}
 Output: {"02.340", "00.12", ".12", "-100"}

 Note: We can convert the string array to Double or BigDecimal array (since they preserves decimal precision)
 by: Double.parseDouble(str) or new BigDecimal(string) for individual elements, but the catch there will be when we
 convert BigDecimal back to string, we lose the leading zeros before decimal, like "00.12" when converted to
 Double or BigDecimal and back to string, it will become "0.12", which is not what we want.
 Hence, the solution in this case is to go for Arrays.sort with string array itself and provide a comparator there
 which uses Double or BigDecimal to compare the strings.

 Also check these out:
 Arrays.sort(s, fromIndex, toIndex, (a, b) -> new BigDecimal(b).compareTo(new BigDecimal(a)));
 Arrays.sort(s, fromIndex, toIndex, (a, b) -> new Double(b).compareTo(new Double(a)));
 Arrays.sort(s, fromIndex, toIndex, (a, b) -> -(new Double(a).compareTo(new Double(b))));
 */

public class SortDecimalsAsStrings {

    public static void main(String[] args) {

        String[] s = {"-100", "00.12", ".12", "02.340"};
        new SortDecimalsAsStrings().sortDecimalsAsString(s);

        for (String str : s) {
            System.out.println(str);
        }

    }

    public void sortDecimalsAsString(String [] strArr) {

        // StaticInnerClassDemo 1)
//        Arrays.sort(strArr, Comparator.comparing((String str) -> {
//            // We can use BigDecimal or Double here to compare strings
//            // BigDecimal decimal = new BigDecimal(str);
//            Double decimal = Double.parseDouble(str);
//            return decimal;
//        }).reversed());

        // StaticInnerClassDemo 2)
        Arrays.sort(strArr, 0, strArr.length, (a, b) -> -(new Double(a).compareTo(new Double(b))));

        // StaticInnerClassDemo 3)
//        Arrays.sort(strArr, 0, strArr.length, (a, b) -> new BigDecimal(b).compareTo(new BigDecimal(a)));

    }
}
