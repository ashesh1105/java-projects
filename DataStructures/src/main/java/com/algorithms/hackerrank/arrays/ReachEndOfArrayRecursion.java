package com.algorithms.hackerrank.arrays;

/*
Its a game of 2D array, you win or lose it, rules as below:
1) A 2D array "game" of integers 0 or 1 as its elements of n length and a given integer leap to jump
2) You can move forward or backward one step at a time or by leap as long as game[i+1], game[i-1] or game[i+leap] == 0
3) If you reach at index n-1 (i.e., end of array) or i+leap >= n, the length of array, you Win. Print YES for it.
4) if you can't move forward anymore and i+leap still less than n, you Lose. Print NO for it.

Example:
n=5, leap=3
game = {0, 0, 0, 0, 0}
Result: YES

n=6, leap=5
game = {0, 0, 0, 1, 1, 1}
Result: YES

n=6, leap=3
game = {0, 0, 1, 1, 1, 0}
Result: NO

n=3, leap=1
game = {0, 1, 0}
Result: NO

n=9, leap=4
game = {0, 1, 1, 0, 0, 1, 1, 0, 1}
Result: YES
(Note: You'll have to get a leap but then move backwards once, then get a leap and then i+leap > n, so you WIN)
*/

public class ReachEndOfArrayRecursion {

    public static void main(String[] args) {

        int [] game = {0, 1, 1, 0, 0, 1, 1, 0, 1};
        int leap = 4;

        System.out.println((canWin(leap, game)) ? "YES" : "NO");
    }


    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        return isSolvable(leap, game, game.length, 0);
    }

    // Using recursion here (DFS)
    // Note, we change the array here by adding 1 to elements where it was 0
    private static boolean isSolvable(int leap, int[] arr, int len, int i) {
        if (i < 0 || arr[i] == 1) return false;
        if ((i == len - 1) || i + leap > len - 1) return true;

        arr[i] = 1;
        return isSolvable(leap, arr, len, i + 1) || isSolvable(leap, arr, len,i - 1)
                || isSolvable(leap, arr, len,i + leap);
    }
}
