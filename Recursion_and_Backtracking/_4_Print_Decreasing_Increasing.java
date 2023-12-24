package Recursion_and_Backtracking;

import java.util.Scanner;

public class _4_Print_Decreasing_Increasing {
//	1. You are given a positive number n. 
//	2. You are required to print the counting from n to 1 and back to n again.
//	3. You are required to not use any loops. Complete the body of pdi function to achieve it. Don't change the signature of the function.
	
//	3 2 1 1 2 3
	
	public static void printID(int n) {
		if(n == 0) {
			return;
		}
		System.out.println(n);
		printID(n-1);
		System.out.println(n);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		printID(n);
	}

}
