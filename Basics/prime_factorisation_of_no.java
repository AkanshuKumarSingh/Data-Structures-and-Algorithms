package Basics;

import java.util.Scanner;

public class prime_factorisation_of_no {
//	1. You are required to display the prime factorization of a number.
//    2. Take as input a number n.
//    3. Print all its prime factors from smallest to largest.

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int no = 2;
		while (a != 1) {
			if (a % no == 0) {
				a /= no;
				System.out.print(no + " ");
			} else {
				no++;
			}
		}
		
		// better		
		for(int i = 2; i*i <= a; i++) { // Max O(√a)
			while(a%i == 0) {
				System.out.print(i + " "); // Max O(log(a))
				a = a/i;
			}
		}
		
		// Net time complexity of above code: O(√a) * O(log(a))
		
		if(a > 1) {
//			for non-prime numbers like 27, 30 we would have a prime no left at the end
//			for prime nos we would have the no at the end
//			for square nos like 25, 9, we would have at the end
//			there may be more cases but thought about these only.
			System.out.println(a);
		}
		
		scan.close();
	}
	
}
