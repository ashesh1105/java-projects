package main.java.com.algorithms.hackerrank.twoDArray;

/**
 * 
For a 2D Array, print the elements in "snake order horizontal" and then "snake order vertical".
Example Input:
A mxn 2D array, 
A = { 
	  {1, 2, 3}, 
	  {4, 5, 6},
	  {7, 8, 9}, 
	  {10, 11, 12}
	};
Output:
a) Snake order horizontal: 1, 2, 3, 6, 5, 4, 7, 8, 9, 12, 11, 10
b) Snake order vertical: 1, 4, 7, 10, 11, 8, 5, 2, 3, 6, 9, 12

StaticInnerClassDemo:
A) Snake Horizontal Order:
1) We basically need to print m rows by varying the direction every time, left to right (to start with) and alternate that
   every time.
2) Take a variable k and assign this to -1.
3) Start first for loop and in that vary i from 0 to m-1.
4) Inside above loop, do k *= -1 (basically toggle it from -1 to +1 in every loop.
5) Have 2 variation of inner for-loop based on whether k > 0 or not, vary j from 0 to n-1 or n-1 to 0 and print A[j][j];

B) Snake Vertical Order:
1) Do exactly reverse of above. Here we need to print columns from 0 to n by alternating the direction every time.
2) Take a variable k and assign this to -1.
3) Start first for loop and in that vary j from 0 to n-1.
4) Inside above loop, do k *= -1 (basically toggle it from -1 to +1 in every loop.
5) Have 2 variation of inner for-loop based on whether k > 0 or not, vary i from 0 to m-1 or m-1 to 0 and print A[j][j];

 *
 */
public class Print2DArraySnakeOrder {

	public static void main(String[] args) {
		
		int [][] A = { 
				    	{1, 2, 3}, 
					    {4, 5, 6},
					    {7, 8, 9}, 
					   {10, 11, 12}
				   };
		
		print2DArraySnakeOrderHorizontal(A, 4, 3);
		
		System.out.println();
		
		print2DArraySnakeOrderVertical(A, 4, 3);

	}

	private static void print2DArraySnakeOrderHorizontal(int[][] A, int m, int n) {
		
		int k = -1;
		
		System.out.println("Printing 2D array in Snake Horizontal Order:");
		
		for (int i=0; i<m; i++) {
			k *= -1;
			if (k > 0) {
				for (int j=0; j<n; j++) {
					System.out.println(A[i][j]);
				}
			} else {
				for (int j=n-1; j>=0; j--) {
					System.out.println(A[i][j]);
				}
			}
		}	
	}
	
	private static void print2DArraySnakeOrderVertical(int[][] A, int m, int n) {
		
		int k=-1;
		
		System.out.println("Printing 2D array in Snake Vertical Order:");
		
		for (int j=0; j<n; j++) {
			k *= -1;
			if (k > 0) {
				for (int i=0; i<m; i++) {
					System.out.println(A[i][j]);
				}
			} else {
				for (int i=m-1; i>=0; i--) {
					System.out.println(A[i][j]);
				}
			}
		}
		
	}

}
