package Basics;

import java.util.Scanner;

public class GCM_and_LCM_of_no {
//	1. You are required to print the Greatest Common Divisor (GCD) of two numbers.
//	2. You are also required to print the Lowest Common Multiple (LCM) of the same numbers.
//	3. Take input "num1" and "num2" as the two numbers.
//	4. Print their GCD and LCM.


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int divisor = a, divident = b,n1 = a,n2 = b;
//        int lcm = 1;
//        int no = 2;
//        while(a > 1 || b > 1){
//        	System.out.println(a + " " + b + " " + no);
//            if(a%no == 0 && b%no == 0){
//                lcm *= no;
//                a /= no;
//                b /= no;
//            }else if(a%no == 0){
//                lcm *= no;
//                a /= no;
//            }else if(b%no == 0){
//                lcm *= no;
//                b /= no;
//            }else{
//                no++;
//            }
//        }
//        System.out.println(lcm);
        
//        lcm second way
//        if(n1 > n2) {
//        	int t = n2;
//        	n2 = n1;
//        	n1 = t;
//        }
//        for(int i = 1; i <= n1; i++) {
//        	if(n2*i % n1 == 0) {
//        		System.out.println(n2*i + " is lcm");
//        		break;
//        	}
//        }
        
        while(divident%divisor != 0) {
        	int rem = divident%divisor;
        	divident = divisor;
        	divisor = rem;
        }
        
        // divisor at end is gcd
        
        System.out.println(divisor);
        int lcm = (n1*n2)/divisor;
        System.out.println(lcm);
        scan.close();
	}

	static int gcd(int divisor, int divident)
	{
		// another way
		if(divident%divisor==0)
			return divisor;

		return gcd(divident%divisor, divisor);
	}
	
}
