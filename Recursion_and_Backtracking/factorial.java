package Recursion_and_Backtracking;

import java.util.Scanner;

public class factorial {
//	1. You are given a number n.
//	2. You are required to calculate the factorial of the number. Don't change the signature of factorial function.

	public static int factorial(int n) {
		if(n == 0)
			return 1;
		int fnm1 = factorial(n-1);
		int fn = n*fnm1;
		return fn;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(factorial(n));
	}

}
