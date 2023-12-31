package funtionAndNumberSystem;

import java.util.Scanner;

public class Any_base_to_decimal {
//	1. You are given a number n.
//	2. You are given a base b. n is a number on base b.
//	3. You are required to convert the number n into its corresponding value in decimal number system.


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int b = scn.nextInt();
		int d = getValueIndecimal(n, b);
		System.out.println(d);
	}

	public static int getValueIndecimal(int n, int b) {
		int power = 1;
		int ans = 0;
		while (n != 0) {
			int rem = n % 10;
			n = n / 10;
			ans += power * rem;
			power *= b;
		}
		return ans;
	}

}
