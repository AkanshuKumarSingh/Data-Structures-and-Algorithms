package Array2D;

import java.util.Scanner;

public class Exit_point_of_Matrix {
//	1. You are given a number n, representing the number of rows.
//	2. You are given a number m, representing the number of columns.
//	3. You are given n*m numbers (1's and 0's), representing elements of 2d array a.
//	4. Consider this array a maze and a player enters from top-left corner in east direction.
//	5. The player moves in the same direction as long as he meets '0'. On seeing a 1, he takes a 90 deg right turn.
//	6. You are required to print the indices in (row, col) format of the point from where you exit the matrix.
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

	public static void exitPoint(int matrix[][], int n, int m) {
		int r = 0, c = 0, dir = 0;

		while (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length) {
			dir = (dir + matrix[r][c]) % 4;
			
			if(dir == 0) {
				c++;	
			}else if(dir == 1) {
				r++;
			}else if(dir == 2) {
				c--;
			}else {
				r--;
			}
			
		}
		
		if(dir == 0) {
			c--;	
		}else if(dir == 1) {
			r--;
		}else if(dir == 2) {
			c++;
		}else {
			r++;
		}
		
		System.out.println(r + "\n" + c);
	}

	public static void main(String[] args) {
		int r = scan.nextInt();
		int c = scan.nextInt();
		int matrix[][] = new int[r][c];

		input(matrix);

		exitPoint(matrix, r, c);

	}

}
