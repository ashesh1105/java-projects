package main.java.com.algorithms.hackerrank.twoDArray;

/**
 Rotate n x n 2D Matrix clockwise
 * 
 StaticInnerClassDemo: Check this video: https://www.youtube.com/watch?v=Jtu6dJ0Cb94
 
 1) Start with a 2 x 2 array and see how you need to swap elements to rotate it clockwise.
 2) Once you can generalize it, apply with 3 x 3 and then with 4 x 4 matrix to test that you don't have a bug.
 3) Basically its like you swap the corners first, then swap element next to corner and go till end of row.
 Say, A, B, C and D denote 4 corners start from top left as A.
 If you swap position of A with B, then again same position (previous position of A) with C, then with D, you
 change the order from A B C D to D A B C.
 4) Define a variable as layer which will vary from 0 to (n-1)/2. Your task is to rotate array one layer at a time.
 5) Within a layer, you need to swap elements based on 3) above, once for corner, then position next to that and so on.
 
 */

public class Rotate2DArray {

	public static void main(String[] args) {

		// 2 x 2 Matrix
		int[][] A = { 
						{ 1, 2 }, 
						{ 3, 4 }

		};
		
		// 3x3 Matrix
		int[][] A3by3 = { 
							{ 1, 2 , 3}, 
							{ 4, 5, 6 },
							{ 7, 8, 9 }

		};
		
		// 4x4 Matrix
		int[][] A4by4 = { 
							{ 1, 2, 3, 4 }, 
							{ 5, 6, 7, 8 },
							{ 9, 10, 11, 12 },
							{ 13, 14, 15, 16 }

		};
		
		// 5x5 Matrix
		int[][] A5by5 = { 
							{ 1, 2, 3, 4, 5 }, 
							{ 6, 7, 8, 9, 10 },
							{ 11, 12, 13, 14, 15 },
							{ 16, 17, 18, 19, 20 },
							{ 21, 22, 23, 24, 25 }
		};

		System.out.println("Original Matrix:");
		printMatrix(A5by5, 5);

		rotate2DArray(A5by5, 5);

		System.out.println("\nRotated Matrix:");
		printMatrix(A5by5, 5);

	}

	private static void rotate2DArray(int[][] A, int n) {

		int last = n - 1;

		for (int layer = 0; layer < (n / 2); layer++) {

			for (int i = layer; i < last-layer; i++) {

				swap(A, layer, i, i, last-layer);
				swap(A, layer, i, last-layer, last-i);
				swap(A, layer, i, last-i, layer);
			}
		}
	}

	private static void swap(int[][] A, int i1, int j1, int i2, int j2) {

		int temp = A[i1][j1];
		A[i1][j1] = A[i2][j2];
		A[i2][j2] = temp;
	}

	private static void printMatrix(int[][] A, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(A[i][j]);
				System.out.print(" ");
			}
			System.out.println();

		}

	}

}
