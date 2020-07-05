package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * You can do List.toArray() to convert a list to array, but you will get an Object array from that!
 * To avoid getting Object[], you need to:
 * 1) Make an empty array of data type and size same as list
 * 2) Pass that empty array as argument when you do list.toArray
 */

public class ListToArray {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(21);
        list.add(22);
        list.add(23);

        // Convert this list to an array
        Integer [] emptyArr = new Integer[list.size()];
        Integer [] result = list.toArray(emptyArr); // Must pass an empty array of same type!

        for (Integer i : result) {
            System.out.println(i);
        }
    }

}
