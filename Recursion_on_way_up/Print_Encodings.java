package Recursion_on_way_up;

import java.util.Scanner;

public class Print_Encodings {
//	1. You are given a string str of digits. (will never start with a 0)
//	2. You are required to encode the str as per following rules
//	    1 -> a
//	    2 -> b
//	    3 -> c
//	    ..
//	    25 -> y
//	    26 -> z
//	3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
//	Use the input-output below to get more understanding on what is required
//	123 -> abc, aw, lc
//	993 -> iic
//	013 -> Invalid input. A string starting with 0 will not be passed.
//	103 -> jc
//	303 -> No output possible. But such a string maybe passed. In this case print nothing.


	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		printEncodings(str, "");
	}

	public static void printEncodings(String str, String ans) {
		if (str.length() == 0) {
			if (ans.length() != 0)
				System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			int no = Integer.parseInt(str.substring(0, i + 1));
			if (no > 26 || no == 0) {
				break;
			}
			printEncodings(str.substring(i + 1), ans + ((char) (no + 96)));
		}

	}

	public static void printEncodingsSir(String qsf, String asf) { // Sir
		if (qsf.length() == 0) {
			System.out.println(asf);
			return;
		}

		if(qsf.charAt(0) == '0') {
			return;
		}
		
		int num1 = qsf.charAt(0) - '0';
		printEncodingsSir(qsf.substring(1),asf + ((char)(num1 - 1 + 'a' )));
		if(qsf.length() > 1) {
			int num2 = qsf.charAt(1) - '0';
			int num = num1*10 + num2;
			if(num <= 26) {
				printEncodingsSir(qsf.substring(2),asf + ((char)(num - 1 + 'a' )));
			}
		}
		

	}

}
