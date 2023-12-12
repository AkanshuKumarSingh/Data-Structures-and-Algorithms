package Recursion_in_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Get_SubSequence {
//	1. You are given a string str.
//	2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
//	Use sample input and output to take idea about subsequences.
//	abc -> [, c, b, bc, a, ac, ab, abc]
	
	public static ArrayList<String> gss(String str) {
		if(str.length() == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}
		
		char ch = str.charAt(0);
        
		ArrayList<String> rres = gss(str.substring(1));
        ArrayList<String> cres = new ArrayList<>();
        for(String s : rres) {
        	cres.add(s);
        }
        for(String s : rres) {
        	cres.add("" + ch + s);
        }
		return cres;
    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().trim();
		System.out.println(gss(str));

	}

}
