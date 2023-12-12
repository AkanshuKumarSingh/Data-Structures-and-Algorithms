package Array2D;

import java.util.Scanner;

public class Saddle_Price {
//	1. You are given a square matrix of size 'n'. You are given n*n elements of the square matrix. 
//	2. You are required to find the saddle price of the given matrix and print the saddle price. 
//	3. The saddle price is defined as the least price in the row but the maximum price in the column of the matrix.
//	Input Format
//	A number n
//	e11
//	e12..
//	e21
//	e22..
//	.. n * n number of elements of array a
//	Output Format
//	Saddle point of the matrix if available or "Invalid input" if no saddle point is there.
	public static Scanner scan = new Scanner(System.in);;

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
	
	public static int minColumnIndex(int arr[][], int r) {
		int n = arr.length;
		int minCol = 0;
		for(int col = 1; col < n; col++) {
			if(arr[r][col] < arr[r][minCol]) {
				minCol = col;
			}
		}
		return minCol;
	}
	
	public static boolean isMaxInCol(int arr[][], int mci, int val) {
		for(int r = 0; r < arr.length; r++) {
			if(arr[r][mci] > val) {
				return false;
			}
		}
		return true;
	}
	
	public static void saddlePoint(int arr[][]) {
		int n = arr.length;
		for(int r = 0 ; r < n; r++) {
			
			int mci = minColumnIndex(arr,r);
			
			int val = arr[r][mci];
			
			boolean isMax = isMaxInCol(arr,mci,val);
			
			if(isMax) {
				System.out.println(val);
				return;
			}
		}
		System.out.println("Invalid input");
	}
	
	public static void main(String[] args) {
		int n = scan.nextInt();
		int matrix[][] = new int[n][n];
		
		input(matrix);
		saddlePoint(matrix);
		display(matrix);
		
	}

}
