package Array2D;

import java.util.Scanner;

public class Search_In_sorted_2d_array {
//	1. You are given a number n, representing the number of rows and columns of a square matrix.
//	2. You are given n * n numbers, representing elements of 2d array a. 
//	Note - Each row and column is sorted in increasing order.
//	3. You are given a number x.
//	4. You are required to find x in the matrix and print it's location int (row, col) format as discussed in output format below.
//	5. In case element is not found, print "Not Found".
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
	
	public static void search(int arr[][], int n, int no) {
		int r = 0, c = n-1;
		while(r < n && c >= 0) {
			if(arr[r][c] == no) {
				System.out.println(r + "\n" + c);
				return;
			}else if(arr[r][c] < no) {
				r++;
			}else {
				c--;
			}
		}
		System.out.println("Not Found");
	}
	
	public static void main(String[] args) {
		int n = scan.nextInt();
		int matrix[][] = new int[n][n];
		input(matrix);
		int no = scan.nextInt();
		search(matrix,n,no);		
	}

}
