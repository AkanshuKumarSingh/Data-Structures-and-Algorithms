package Basics;

import java.util.Scanner;

public class Digits_Of_Number {
//	1. You've to display the digits of a number.
//	2. Take as input "n", the number for which digits have to be displayed.
//	3. Print the digits of the number line-wise.
	
// Output: 
//	d1
//	d2
//	d3
//	... digits of the number
	
	public static void main(String[] args) {
		// Time Complexity: O(logn)
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int t = num;
		int cnt = 0;
		while(t != 0) {
			t = t/10;
			cnt++;
		}
		
		// pow will take O(logn)
		int power = (int) Math.pow(10, cnt-1);
		while(cnt != 0) {
		    System.out.println(num/power);
		    num = num%power;
			power = power/10;
			cnt--;
		}
		scan.close();
		
	}

}
