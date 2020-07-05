package com.algorithms.hackerrank.deque;

import java.util.*;

/**
 * In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is 
 * an abstract data type that generalizes a queue, for which elements can be added to or removed from 
 * either the front (head) or back (tail). Deque interfaces can be implemented using various types of collections 
 * such as LinkedList or ArrayDeque classes. For example, deque can be declared as:
 * Deque deque = new LinkedList<>(); or
 * Deque deque = new ArrayDeque<>();
 *
 * In this problem, you are given N integers. You need to find the maximum number of unique integers 
 * among all the possible contiguous subarrays of size M.
 * 
 * Sample Input (Number of integers and subarray size on first line, integers on second line):
   6 3
   5 3 5 2 3 2
   Output:
   3
   Explanation:
   Subarray [5, 3, 5] -> Unique chars: 2
   Subarray [3, 5, 2] -> Unique chars: 3
   Subarray [5, 2, 3] -> Unique chars: 3
   Subarray [2, 3, 2] -> Unique chars: 2
   Answer: 3
 */

public class UniqueIntegersAmongAllSubarrays {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            set.add(num);
            // Check the subarray of size m
            // Once i reaches m, below if-condition will evaluate for each i
            if (deque.size() == m) {
                // size of set will be the number of unique integers for this subarray
                if (max < set.size()) max = set.size();
                // time to remove first element of queue so we look at next subarray of size m
                Integer first = deque.removeFirst();
                // Remove first element from deque from set only if it was not
                // present multiple times in deque
                if (!deque.contains(first)) set.remove(first);
            }
        }
        System.out.println(max);
    }
}
