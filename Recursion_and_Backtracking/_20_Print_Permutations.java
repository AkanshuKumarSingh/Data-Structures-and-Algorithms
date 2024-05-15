package Recursion_and_Backtracking;

import java.util.Scanner;

public class _20_Print_Permutations {
//	1. You are given a string str.
//	2. Complete the body of printPermutations function - without changing signature - to calculate and print all permutations of str.
//Input : abc -> 
//Output: abc
//acb
//bac
//bca
//cab
//cba
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().trim();
		printPermutations(str,"");
	}

	public static void printPermutations(String str,String ans) {
		if(str.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			String firstHalf = str.substring(0,i);
			String secondHalf = str.substring(i+1);
			
			printPermutations(firstHalf + secondHalf , ans + ch);
		}
		
	}

}
