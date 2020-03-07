package main.java.com.algorithms.hackerrank.twoDArray;

import java.util.Scanner;

public class HourGlass {
	
	/**
	 * Given a 2D array, find the max sum of hour glass elements.
	 * 
	 * Sample Input:
	 * 6x6 array:
	  	1 1 1 0 0 0
		0 1 0 0 0 0
		1 1 1 0 0 0
		0 9 2 -4 -4 0
		0 0 0 -2 0 0
		0 0 -1 -2 -4 0
		Here first hour glass can be elements from [0][0] as:
		1 x 1
		x 1 x
		1 1 1
		Here x is the element we don't care. Second one could be from [0][1]
		1 1 0
		x 0 x
		1 1 0
		
		Expected Result as max sum:
		13
	 */

	public static void main(String[] args) {
		
		int[][] arr = new int[6][6];
		System.out.println("Please enter the elements of a 2D metrics with a space between numbers and enter at every line (row):");
		System.out.println("Example:");
		System.out.println("1 1 1 0 0 0\n" + 
				"0 1 0 0 0 0\n" + 
				"1 1 1 0 0 0\n" + 
				"0 9 2 -4 -4 0\n" + 
				"0 0 0 -2 0 0\n" + 
				"0 0 -1 -2 -4 0");
        final Scanner scanner = new Scanner(System.in);
        
        // It is better to initialize this to as low as possible in case highest value in array is a negative value
        int sum = Integer.MIN_VALUE;

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
                if (i > 1 && j > 1) {
                    int temp = arr[i][j] + arr[i][j-1] + arr[i][j-2]
                        + arr[i-1][j-1]
                        + arr[i-2][j] + arr[i-2][j-1] + arr[i-2][j-2];
                    if (sum < temp) sum = temp;
                }
            }
        }
        System.out.println(sum);
        scanner.close();
    }
	
	/**
	 * Explanation of above solution:
	 * What's happening here is you are basically filling, row by row, a 6x6 matrix. As soon as you happen to have 
	 * filled 2 rows of this matrix and the first 3 elements of the third row, you have enough elements in this matrix 
	 * to calculate your first hourglass. Let's visualise it :
		  0 1 2 3 4 5 => Indices (j)
		0 h h h a a a
		1 a h a a a a
		2 h h x

	* Here the 'h' are the positions of the hourglass we want to get, 'a' the positions in the matrix actually not 
	* interesting to us, and 'x' the actual position we just filled (our new 'h' from where we are seeing this hour glass)
	* As you can see, the actual values of our i (the number of the row we are actually filling) and j (the number of the column)
	* is 2,2. So, knowing this, getting the position of the other 'h' relative to the actual position is straightforward.
		  0 1 2 3 4 5
		0 h h h a a a
		1 a h a a a a
		2 h y x

	* y here is the same row as x (so same i) but one column less (so j - 1). And that's how we obtain the first value
	* from the actual x : a[i][j-1]. Another example:
		  0 1 2 3 4 5
		0 z h h a a a
		1 a h a a a a
		2 h h x
	* z here is 2 rows less than the actual x, and 2 columns less, so the actual value of z is a[i-2][j-2].
	* So the sum you see in my code : int sum = a[i][j]+a[i][j-1]+a[i][j-2]+a[i-1][j-1]+a[i-2][j]+a[i-2][j-1]+a[i-2][j-2];
	* is actually the hour glass calculated in this order :
		7 6 5 a a a
		a 4 a a a a
		3 2 1

	* We stock this sum in the variable sum. But the matrix is not full yet ! What happens when we fill the next number ? 
	* We immediately obtain a new hour glass we can calculate :
		  0 1 2 3 4 5
		0 a h h h a a
		1 a a h a a a
		2 a h h x

	* Do you see the pattern ? We can repeat the same calculation we did precendently to get the value of the hour glass, 
	* and from now on, we just keep the greatest result.
	* The trick is to not allow ArrayOutOfBounds in the matrix.
	* Example:
		  0 1 2 3 4 5
		0 a a a a a a
		1 a a a a a a
		2 a a a a a a
		3 a x

	* Here, i = 3 and j = 1. Trying to calculate an hour glass using the precedent pattern would result in doing 
	* something like ...+a[j-2]+..., therefore going outside the boundary of the matrix and crashing the program.
	* Hence the condition we set before doing each calculation :

	* if (i > 1 && j > 1){...

	* basically guaranteeing that i and j are always at least 2.
	*/

}
