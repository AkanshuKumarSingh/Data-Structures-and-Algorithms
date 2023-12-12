package funtionAndNumberSystem;

import java.util.Scanner;

public class Decimal_to_anyConvert {
//	1. You are given a decimal number n.
//	2. You are given a base b.
//	3. You are required to convert the number n into its corresponding value in base b.

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int b = scn.nextInt();
		int dn = getValueInBase(n, b);
		System.out.println(dn);
	}

	public static int getValueInBase(int n, int div) {
//         to convert decimal into any form just find remainder at each step 
//			dividing them at each step
//		 	8|987 - remainder
//		 	8|123 - 3
//		 	8|15  - 3
//		 	8|1   - 7
//		 	 |0   - 1

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

}




