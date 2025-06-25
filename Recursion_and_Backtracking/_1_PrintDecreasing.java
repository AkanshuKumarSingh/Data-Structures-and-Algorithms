package Recursion_and_Backtracking;

import java.util.Scanner;

public class _1_PrintDecreasing {
//	1. You are given a positive number n. 
//	2. You are required to print the counting from n to 1.
//	3. You are required to not use any loops. Complete the body of print Decreasing function to achieve it.


	// High level analysis f(5) = 5 4 3 2 1 and f(4) = 4 3 2 1
	// f(5) = Sysout(5) + f(4)
	
	// Low level analysis = to find table and find base case;
	
	public static void printDecreasing(int n) {
		if(n == 0) {
			// always think of base case as smallest possible input so we can take both n = 0 or n = 1
			// but you can see that n = 1 can also work in below code so choose 0 try this thing always
			// choose the smallest not that one which fits in the code it will be nice
			return;
		}
		System.out.println(n);
		printDecreasing(n-1);
	}

//	def print_decreasing(n):
//	    if n == 0:
//	        # Base case: smallest possible input
//	        return
//	    print(n)
//	    print_decreasing(n - 1)

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		printDecreasing(n);
	}

}
