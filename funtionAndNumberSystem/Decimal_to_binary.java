package funtionAndNumberSystem;

import java.util.Scanner;

public class Decimal_to_binary {
	
	public static int decimalToBinary(int n) {
		int rem = 0;
		int div = 2;
		int ans = 0;
		int pow = 1;
		while(n != 0) {
			rem = n%div;
			n = n/div;
			ans = rem*pow + ans;
			pow *= 10;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println("HHM");
		Scanner scan = new Scanner(System.in);	
		
		int n = scan.nextInt();
		int res = decimalToBinary(n);
		
		System.out.println(res);
		System.out.println(Integer.toBinaryString(n));
		
	}

}
