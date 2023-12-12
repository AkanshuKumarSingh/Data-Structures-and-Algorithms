package Recursion_on_way_up;

import java.util.Scanner;

public class Print_Subsequence {
//	1. You are given a string str.
//	2. Complete the body of printSS function - without changing signature - to calculate and print all subsequences of str.
//	Input: yvTA
//	Output:
//	yvTA
//	yvT
//	yvA
//	yv
//	yTA
//	yT
//	yA
//	y
//	vTA
//	vT
//	vA
//	v
//	TA
//	T
//	A

	public static void printSS(String str, String ans) {
		if(str.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		char curr = str.charAt(0);
		String newString = str.substring(1);
		
		printSS(newString,ans+curr);
		printSS(newString,ans);
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		printSS(str,"");
	}

}
