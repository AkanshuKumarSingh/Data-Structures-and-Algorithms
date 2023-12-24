package Recursion_and_Backtracking;

import java.util.Scanner;

public class _3_Print_Increasing_Decreasing {
	
//	1 2 3 3 2 1
	
	public static void printID(int n,int i) {
		if(i > n) {
			return;
		}
		System.out.println(i);
		printID(n,i+1);
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		printID(n,1);
	}

}
