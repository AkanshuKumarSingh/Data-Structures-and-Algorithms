package Recursion_and_Backtracking;

import java.util.Scanner;

public class _6_power_linear {
//	1. You are given a number x.
//	2. You are given another number n.
//	3. You are required to calculate x raised to the power n. Don't change the signature of power function .
	
	public static int power(int x, int n) {
		if(n == 0) {
			return 1;
		}
		
		int pxnm1 = power(x,n-1);
		int pxn = pxnm1*x;
		return pxn;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int n = scan.nextInt();
		System.out.println(power(x,n));
	}

}
