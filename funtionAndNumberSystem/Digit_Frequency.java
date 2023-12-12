package funtionAndNumberSystem;

import java.util.Scanner;

public class Digit_Frequency {
//	1. You are given a number n.
//	2. You are given a digit d.
//	3. You are required to calculate the frequency of digit d in number n.


	 public static int getDigitFrequency(int n, int d) {
		 int cnt = 0;
		 while(n > 0) {
			 int no = n%10;
			 n = n/10;
			 if(no == d)
				 cnt++;
		 }
		 return cnt;
	 }
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
	}

}
