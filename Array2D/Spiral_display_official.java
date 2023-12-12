package Array2D;

import java.util.Scanner;

public class Spiral_display_official {
//	1. You are given a number n, representing the number of rows.
//	2. You are given a number m, representing the number of columns.
//	3. You are given n*m numbers, representing elements of 2d array a.
//	4. You are required to traverse and print the contents of the 2d array in form of a spiral.
//	Note - Please check the sample output for details.
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

	public static void printSpiral(int matrix[][]) {
		int rowMin = 0;
		int rowMax = matrix.length-1;
		int colMin = 0;
		int colMax = matrix[0].length-1;
		int ele = 0,totE = matrix.length*matrix[0].length;
		
		while(ele < totE) {
			for(int i = rowMin; i <= rowMax && ele < totE; i++) {
				System.out.println(matrix[i][colMin]);
			    ele++;
			}
			colMin++;
			
			for(int i = colMin; i <= colMax && ele < totE; i++) {
				System.out.println(matrix[rowMax][i]);
    			ele++;
			}
			rowMax--;
			
			for(int i = rowMax; i >= rowMin && ele < totE; i--) {
				System.out.println(matrix[i][colMax]);
				ele++;
			}
			colMax--;
			
			for(int i = colMax; i >= colMin && ele < totE; i--) {
				System.out.println(matrix[rowMin][i]);
				ele++;
			}
			rowMin++;
		}
		
	}
	
	public static void main(String[] args) {
		int r = scan.nextInt();
		int c = scan.nextInt();
		int matrix[][] = new int[r][c];

		input(matrix);

		display(matrix);
		
		printSpiral(matrix);

	}

}
