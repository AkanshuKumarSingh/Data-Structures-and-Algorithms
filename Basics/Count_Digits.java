package Basics;

import java.util.Scanner;

public class Count_Digits {
//	1. You've to count the number of digits in a number.
//	2. Take as input "n", the number for which the digits has to be counted.
//	3. Print the digits in that number.
	
	public static void main(String[] args) {
//		Time Complexity: O(logn)
		Scanner scan = new Scanner(System.in);
	    int n = scan.nextInt();
	    int cnt = 0;
	    while(n != 0){
	        n = n/10;
	        cnt++;
	    }
	    System.out.println(cnt);
	    scan.close();
	}

}
