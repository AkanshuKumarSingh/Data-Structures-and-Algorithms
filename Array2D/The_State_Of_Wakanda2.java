package Array2D;

import java.util.Scanner;

public class The_State_Of_Wakanda2 {

//	The historic state of Wakanda has various monuments and souveniers which are visited by many travellers every day. The guides follow a prescribed route of visiting the monuments which improves them understand the relevance of each monument. The route of the monument is fixed and expressed in a 2-d matrix where the travellers visit the prescribed next monument. For example
//	1  2  3
//	4  5  6
//	7  8  9
//	is the prescribed route and the visitors travels this path: 1->2->3->4->5->6->7->8->9
//	However, a certain visitor decides to travel a different path as follows:
//	1. The visitor only plans to visit the upper diagonal triangle of the monument list.
//	2. The visitor travels diagonally till there are no more moves left in the current journey. 
//	3. He then visits the adjacent monument to the first monument of current diagonal journey. 
//	4. He continues the same path till all the monuments of the upper half have been travelled.
//	For Example:
//	The monuments are named as:
//	1    2    3    4
//	5    6    7    8
//	9   10  11  12
//	13 14  15  16
//	The path followed by the visitor is: 1->6->11->16->2->7->12->3->8->4
//	You are required to print the path followed by the traveller to visit all the monuments.
//	Refer to the photo for a better clarification.
//	1. You are given a number n, representing the number of rows and columns of a square matrix.
//	2. You are given n * n numbers, representing elements of 2d array a.

	
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
	
	public static void printIt(int matrix[][]) {
		
		int n = matrix.length;
		for(int d = 0; d < n; d++) {
			int r = 0;
			int c = d;
			while(r < n-d) {
				System.out.println(matrix[r][c]);
				r++;
				c++;
			}
		}
		
//		for(int col = 0; col < matrix.length; col++) { // col = d in above
//			int i = 0; // both code are same but i one row is checked in other column is check
//			int j = col;
//			while(j < matrix.length) {
//				System.out.println(matrix[i][j]);
//				i++;
//				j++;
//			}
//		}
	}
	
	public static void main(String[] args) {
		int n = scan.nextInt();
		int matrix[][] = new int[n][n];
		
		input(matrix);
		display(matrix);
		printIt(matrix);
		
	}


}
