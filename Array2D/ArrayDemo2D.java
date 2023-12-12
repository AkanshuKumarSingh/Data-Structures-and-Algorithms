package Array2D;

import java.util.Scanner;

public class ArrayDemo2D {
//	1. You are given a number n, representing the number of rows.
//	2. You are given a number m, representing the number of columns.
//	3. You are given n*m numbers, representing elements of 2d array a.
//	4. You are required to display the contents of 2d array as suggested by output format below.

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
	
	public static void main(String[] args) {
		int r = scan.nextInt();
		int c = scan.nextInt();
		int matrix[][] = new int[r][c];
		
		input(matrix);
		
		display(matrix);
		
	}

}
