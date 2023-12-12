package Recursion_in_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class getKPC {
//	1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
//	2. The following list is the key to characters map :
//	    0 -> .;
//	    1 -> abc
//	    2 -> def
//	    3 -> ghi
//	    4 -> jkl
//	    5 -> mno
//	    6 -> pqrs
//	    7 -> tu
//	    8 -> vwx
//	    9 -> yz
//	3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be produced by the keys in str.
//	Use sample input and output to take idea about output.
//		78 -> [tv, tw, tx, uv, uw, ux]

	public static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };
	
	public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0) {
        	ArrayList<String> list = new ArrayList<>();
        	list.add("");
        	return list;
        }
        
        int no = str.charAt(0) - '0';
        String code = codes[no];
        
		ArrayList<String> rres = getKPC(str.substring(1));
		ArrayList<String> cres = new ArrayList<>();
		
		for(int i = 0 ; i < code.length(); i++) {
			for(String s : rres) {
				cres.add("" + code.charAt(i) + s);	
			}
		}
		
		return cres;
    }
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String no = scan.nextLine().trim();
		System.out.println(getKPC(no));		
	}
	
}
