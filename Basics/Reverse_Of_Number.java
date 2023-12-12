package Basics;

import java.util.Scanner;

public class Reverse_Of_Number {
	
//	1. You've to display the digits of a number in reverse.
//	2. Take as input "n", the number for which digits have to be display in reverse.
//	3. Print the digits of the number line-wise, but in reverse order.
//	Input Format
//	"n" where n is any integer.
//	Output Format
//	d1
//	d2
//	d3
//	... digits of the number in reverse

	public static void main(String[] args) {
//		Time Complexity = O(logn)
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		while (n > 0) {
			System.out.println(n % 10);
			n = n / 10;
		}
	}

}
