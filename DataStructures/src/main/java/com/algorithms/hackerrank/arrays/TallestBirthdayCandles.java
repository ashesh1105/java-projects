package com.algorithms.hackerrank.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 You are in charge of the cake for a child's birthday. You have decided the cake will have one candle for each year
 of their total age. They will only be able to blow out the tallest of the candles. Count how many candles are tallest.

 Example:
 candles = [4,4,1,3]
 The maximum height candles are 4 units high. There are 2 of them, so return 2.
 */

public class TallestBirthdayCandles {

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        // Null and empty checks
        if (candles == null || candles.size() == 0) return 0;

        // Return 1 if size is 1, there's nothing to compare against
        if (candles.size() == 1) return 1;

        int size = candles.size();
        int max = candles.get(0);
        int result = 0;
        for (int i=0; i<size; i++) {
            if (candles.get(i) > max) {
                max = candles.get(i);
            }
        }

        for (int i=0; i<size; i++) {
            if (candles.get(i) == max) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(4);
        list.add(1);
        list.add(3);

        System.out.println("Number of Birthday candles that will be blown off: " + birthdayCakeCandles(list));

    }


}
