package Array2D;

import java.util.Scanner;

public class Rotate_matrix_by_90 {
//	1. You are given a number n, representing the number of rows and number of columns.
//	2. You are given n*n numbers, representing elements of 2d array a.
//	3. You are required to rotate the matrix by 90 degree clockwise and then display the contents using display function.
//	*Note - you are required to do it in-place i.e. no extra space should be used to achieve it .*
	public static Scanner scan = new Scanner(System.in);

	public static void input(int matrix[][]) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0 ; j < matrix[i].length; j++) {
				matrix[i][j] = scan.nextInt();
			}
		}
	}
	
	public static void display(int matrix[][]) {
		for(int i = 0 ; i < matrix.length; i++) {
			for(int j = 0 ; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void reverse(int matrix[][]) {
		for(int i = 0 ; i < matrix.length; i++) {
			int left = 0,right = matrix.length-1;
			while(left < right) {
				int t = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = t;
				left++;
				right--;
			}
		}
	}
	
	public static void rotate(int matrix[][], int r, int c) {
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < i; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = t;
			}
		}
		
//		for(int i = 0; i < r; i++) { both are correct for transpose
//			for(int j = i; j < c; j++) {
//				int t = matrix[i][j];
//				matrix[i][j] = matrix[j][i];
//				matrix[j][i] = t;
//			}
//		}
		reverse(matrix);
		display(matrix);
	}
	
	public static void main(String[] args) {
		int r = scan.nextInt();
		int c = scan.nextInt();
		int matrix[][] = new int[r][c];
		
		input(matrix);
		display(matrix);
		rotate(matrix,r,c);
	
		
	}

}
