package Recursion_and_Backtracking;

import java.util.Scanner;

public class print_All_SubString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().trim();
		for(int i = 0 ; i < str.length(); i++) {
			for(int j = i+1; j <= str.length(); j++) {
				System.out.println(str.substring(i,j));
			}
		}
	}

}
