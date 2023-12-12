package funtionAndNumberSystem;

import java.util.Scanner;

public class Any_base_subtraction {
//	1. You are given a base b.
//	2. You are given two numbers n1 and n2 of base b.
//	3. You are required to subtract n1 from n2 and print the value.

	public static int getDifference(int b, int n1, int n2) {
		int carry = 0;
		int ans = 0;
		int power = 1;
		while(n1 != 0 || n2 != 0 || carry != 0) { // just n2 != 0 is enough
			int val1 = n1%10;
			n1 /= 10;
			
			int val2 = n2%10;
			n2 /= 10;
			
			int val = val2 + carry - val1;
			if(val < 0) {
				carry = -1;
				val += b;
			}else {
				carry = 0;
			}
			ans += (power*val);
			power *= 10;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		  Scanner scn = new Scanner(System.in);
	      int b = scn.nextInt();
	      int n1 = scn.nextInt();
	      int n2 = scn.nextInt();
	  
	      int d = getDifference(b, n1, n2);
	      System.out.println(d);
	}

}
