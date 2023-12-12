package Basics;

import java.util.Scanner;

public class Rotate_A_Number_better {
//	1. You are given two numbers n and k. You are required to rotate n, k times to the right. If k is positive, rotate to the right i.e. remove rightmost digit and make it leftmost. Do the reverse for negative value of k. Also k can have an absolute value larger than number of digits in n.
//	2. Take as input n and k.
//	3. Print the rotated number.
//	4. Note - Assume that the number of rotations will not cause leading 0's in the result. e.g. such an input will not be given
//	   n = 12340056
//	   k = 3
//	   r = 05612340


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int no = scan.nextInt();
		int k = scan.nextInt();
		int len = Integer.toString(no).length();
		k = k%len;
		if(k < 0) {
			k = k + len;
		}
		
		int pow1 = (int) Math.pow(10, k);
		int pow2 = (int) Math.pow(10, len-k);
		
		int sec_half = no%pow1;
		int f_half = no/pow1;
		
		sec_half *= pow2;
		int ans = sec_half + f_half;
		System.out.println(ans);
		scan.close();
		
	}

}
