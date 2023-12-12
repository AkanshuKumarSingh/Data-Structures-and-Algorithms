package Basics;

import java.util.Scanner;

public class Rotate_A_Number {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int len = Integer.toString(n).length();
		if(k < 0) {
			k = k*-1;
			k = k % len;
			k = len-k;
		}else
		    k = k % len;
		len--;
		while (k-- > 0) {
			int rem = n % 10;
			n = n / 10;
			n += (int) Math.pow(10, len) * rem;
		}
		System.out.println(n);
		scan.close();

	}

}
