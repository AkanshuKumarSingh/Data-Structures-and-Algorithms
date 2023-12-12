package Basics;

import java.util.Scanner;

public class Pythagorean_Triplet {
//	1. You are required to check if a given set of numbers is a valid pythagorean triplet.
//	2. Take as input three numbers a, b and c.
//	3. Print true if they can form a pythagorean triplet and false otherwise.


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        if(a*a == (b*b + c*c)){
            System.out.println(true);
        }else if(b*b == (a*a + c*c)){
            System.out.println(true);
        }else if(c*c == (a*a + b*b)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        scan.close();
	}

}
