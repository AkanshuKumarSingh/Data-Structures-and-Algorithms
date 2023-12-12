package Array2D;

import java.util.Scanner;

public class The_State_Of_Wakanda {
//	The historic state of Wakanda has various monuments and souvenirs which are visited by many travelers every day. The guides follow a prescribed route of visiting the monuments which improve them understand the relevance of each monument. 
//
//	The route of the monument is fixed and expressed in a 2-d matrix where the travelers visit the prescribed next monument. For example
//
//	1  2  3
//	4  5  6
//	7  8  9
//
//	is the prescribed route and the visitors travels this path: 1->2->3->4->5->6->7->8->9
//
//	However, a certain visitor decides to travel a different path as follows: 
//	1. He first travels southwards till no further south places are available.
//	2. He then moves only 1 place eastwards.
//	3. He starts to move again towards north till any further north moves are available. 
//	This continues till all the places are covered. 
//
//	For example, the monuments are named as follows:
//	1  2  3
//	4  5  6
//	7  8  9
//
//	Path followed by traveler: 1->4->7->8->5->2->3->6->9
//
//	You are required to print the path that this traveler follows to visit all places.
//
//
//	1. You will be given a number n, representing the number of rows.
//	2. You will be given a number m, representing the number of columns.
//	3. You will be given n*m numbers, representing elements of 2d arrays.

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
	
	public static void printIt(int matrix[][]) {
		for(int j = 0 ; j < matrix[0].length; j++) {
			if(j%2 == 0) {
				for(int i = 0 ; i < matrix.length; i++) {
					System.out.println(matrix[i][j]);
				}
			}else {
				for(int i = matrix.length-1; i >= 0; i--) {
					System.out.println(matrix[i][j]);
				}
			}
		}
	}

	public static void main(String[] args) {
		int r = scan.nextInt();
		int c = scan.nextInt();
		int matrix[][] = new int[r][c];

		input(matrix);
		display(matrix);
		printIt(matrix);

	}
}
