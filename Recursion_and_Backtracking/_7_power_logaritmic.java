package Recursion_and_Backtracking;

import java.util.Scanner;

public class _7_power_logaritmic {
//	1. You are given a number x.
//	2. You are given another number n.
//	3. You are required to calculate x raised to the power n. Don't change the signature of power function.

	public static int power(int no, int pow) {
		if (pow == 0) {
			return 1;
		}

		int halfVal = power(no, pow / 2);
		int val = halfVal*halfVal;
		
		if (pow % 2 == 1) {
			val *= no;
		}
		
		return val;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int no = scan.nextInt();
		int pow = scan.nextInt();
		System.out.println(power(no, pow));

	}

}
