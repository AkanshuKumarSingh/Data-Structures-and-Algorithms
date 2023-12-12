package funtionAndNumberSystem;

import java.util.Scanner;

public class Any_base_to_any_base {
//	1. You are given a number n.
//	2. You are given a base b1. n is a number on base b.
//	3. You are given another base b2.
//	4. You are required to convert the number n of base b1 to a number in base b2.

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

	public static int getValueInBase(int n, int div) {
		int rem = 0;
		int ans = 0;
		int pow = 1;
		while (n != 0) {
			rem = n % div;
			n = n / div;
			ans = rem * pow + ans;
			pow *= 10;
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int sourceBase = scn.nextInt();
		int destBase = scn.nextInt();
		int decimal_no = getValueIndecimal(n, sourceBase);
		int anyBase = getValueInBase(decimal_no, destBase);
		System.out.println(anyBase);
	}

}
