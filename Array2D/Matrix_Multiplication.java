package Array2D;

import java.util.Scanner;

public class Matrix_Multiplication {
//	1. You are given a number n1, representing the number of rows of 1st matrix.
//	2. You are given a number m1, representing the number of columns of 1st matrix.
//	3. You are given n1*m1 numbers, representing elements of 2d array a1.
//	4. You are given a number n2, representing the number of rows of 2nd matrix.
//	5. You are given a number m2, representing the number of columns of 2nd matrix.
//	6. You are given n2*m2 numbers, representing elements of 2d array a2.
//	7. If the two arrays representing two matrices of dimensions n1 * m1 and n2 * m2 can be multiplied, display the contents of prd array as specified in output Format.
//	8. If the two arrays can't be multiplied, print "Invalid input".

	public static Scanner scan = new Scanner(System.in);;

	public static void input(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = scan.nextInt();
			}
		}
	}

	public static void display(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void multiply(int arr1[][], int arr2[][], int r1, int r2,int c1, int c2) {
		int mat[][] = new int[r1][c2];
		
		for(int i = 0; i < r1; i++) {
			for(int j = 0 ; j < c2; j++) {
				int res = 0;
				for(int k = 0; k < r2; k++) {
					res += (arr1[i][k]*arr2[k][j]);
				}
				mat[i][j] = res;
			}
		}
		
		display(mat);
		
	}

	public static void main(String[] args) {
		int r1 = scan.nextInt();
		int c1 = scan.nextInt();
		int arr1[][] = new int[r1][c1];
		input(arr1);

		int r2 = scan.nextInt();
		int c2 = scan.nextInt();
		int arr2[][] = new int[r2][c2];
		input(arr2);

		if (c1 == r2) {
			multiply(arr1, arr2, r1, c1, r2, c2);
		} else {
			System.out.println("Invalid iput");
		}

	}

}
