package Recursion_and_Backtracking;

import java.util.Scanner;

public class _16_printKPC {
//	1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
//	2. The following list is the key to characters map
//	    0 -> .;
//	   1 -> abc
//	   2 -> def
//	   3 -> ghi
//	   4 -> jkl
//	   5 -> mno
//	   6 -> pqrs
//	   7 -> tu
//	   8 -> vwx
//	   9 -> yz
//	3. Complete the body of printKPC function - without changing signature - to print the list of all words that could be produced by the keys in str.
//	   78
//	tv
//	tw
//	tx
//	uv
//	uw
//	ux
	static String keys[] = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	public static void printKPC(String no,String ans) {
		if(no.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		int n = no.charAt(0) - '0';
		String newNo = no.substring(1);
		
		for(int i = 0; i < keys[n].length(); i++) {
			printKPC(newNo,ans+keys[n].charAt(i));
		}
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String no = scan.nextLine();
		printKPC(no,"");
	}

}
