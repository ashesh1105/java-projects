package com.algorithms.hackerrank.strings;

/*

Given a string s, and an integer k, complete the function so that it finds the lexicographically smallest and
largest substrings of length k. s consists of English alphabetic letters only (i.e., [a-zA-Z]).

Example:
Lexicographical order example: ball < cat, dog < dorm, Happy < happy, Zoo < ball.

For string "welcomejava" has the following lexicographically-ordered substrings of length k=3:
["ava", "com", "elc", "eto", "jav", "lco", "met", "oja", "ome", "toj", "wel"]

Result will be smallest substring on first line and largest on second line ("smallest%nlargest")
ava
wel

*/

import org.apache.commons.lang3.StringUtils;

public class LargestSmallestSubstringLexographicalOrder {

    public String getLargestSmallestSubstringsLexicographicalOrder(String s, int k) {

        if (StringUtils.isEmpty(s) || k == 0) {

            System.out.println("s null or empty or k = 0!");
            return "ERROR!";
        }

        if (k > s.length()) {

            System.out.println("k can not be greater than length of input string!");
            return "ERROR!";
        }

        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'


        for (int i = 0, j = i + k - 1; j < s.length(); i++, j++) {

            String temp = s.substring(i, j + 1);

            if (isGreater(smallest, temp)) {
                smallest = temp;
            } else if (isGreater(temp, largest)) {
                largest = temp;
            }
        }

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {

        String result1 = new LargestSmallestSubstringLexographicalOrder()
                .getLargestSmallestSubstringsLexicographicalOrder("welcomeTojava", 3);

        System.out.println(result1);
    }

    private static boolean isGreater(String s1, String s2) {

        boolean result = false;

        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {

            if (s1.charAt(i) < s2.charAt(j)) {
                break;
            } else if (s1.charAt(i) > s2.charAt(j)) {
                result = true;
                break;
            } else {
                continue;
            }
        }
        return result;
    }
}
