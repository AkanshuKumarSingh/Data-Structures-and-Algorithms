package Basics;

import java.util.*;

public class print_all_prime_nos {
//	1. You've to print all prime numbers between a range. 
//	2. Take as input "low", the lower limit of range.
//	3. Take as input "high", the higher limit of range.
//	4. For the range print all the primes numbers between low and high (both included).

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int low = scan.nextInt();
		int high = scan.nextInt();
		
		// O(n√n) sol which is not good
		for (int j = low; j <= high; j++) {
			int no = j;
			boolean flag = true;
			for (int i = 2; i * i <= no; i++) {
				if (no % i == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.print(no + ", ");
			}
		}
		System.out.println();
		
		// Sieve method
		Sieve1(high);
		
		scan.close();
	}
	
	
	//	better approach is to use sieve
	//	https://www.topcoder.com/thrive/articles/sieve-of-eratosthenes-algorithm
	//  https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Mathematics/video/MTg1MA%3D%3D
	//  https://www.geeksforgeeks.org/segmented-sieve-print-primes-in-a-range/
	
	public static void Sieve1(int high) {
	//	Time Complexity:  O(n * log(log(n)) ) -> take this as O(n) as log(log(n)) is approx. constant
	//  Space Complexity: O(n)
		
		boolean isPrime[] = new boolean[high+1];
		Arrays.fill(isPrime, true);
		
		for(int i = 2; i*i <= high; i++) {
			if(isPrime[i]) {
				for(int j = i*2; j <= high; j = j+i) {
					isPrime[j] = false;
				}
			}
		}
				
		for(int i = 2; i <= high; i++) {
			if(isPrime[i])
				System.out.print(i + " ");
		}
		
	
// Explanation
//		Let's reevaluate the time complexity of the given code for finding prime numbers using the Sieve of Eratosthenes algorithm:
//
//		Initializing the isPrime array: The initialization of the isPrime array with Arrays.fill(isPrime, true); takes O(n) time, where 'n' is the size of the array, which is high + 1.
//
//		Sieve of Eratosthenes algorithm: The main part of the algorithm is the first loop that iterates from 2 to the square root of high (for (int i = 2; i * i <= high; i++)). For each prime number 'i' within this range, the inner loop (for (int j = i * 2; j <= high; j = j + i)) marks the multiples of 'i' as composite (not prime).
//
//		Let's analyze the number of iterations of the inner loop for each 'i':
//
//		For 'i' = 2, we mark every even number from 4 to high, giving us approximately high/2 iterations.
//		For 'i' = 3, we mark every third number from 6 to high, giving us approximately high/3 iterations.
//		For 'i' = 5, we mark every fifth number from 10 to high, giving us approximately high/5 iterations.
//		... and so on.
//		The total number of iterations of the inner loop can be approximated as follows:
//
//		Iterations ≈ high/2 + high/3 + high/5 + ... + high/sqrt(high)
//
//		This series is known as the sum of the reciprocals of prime numbers up to sqrt(high), and it is approximately O(high * log(log(high))). The prime number theorem states that the number of prime numbers less than or equal to 'n' is approximately n / log(n). Using this approximation, we can arrive at the above complexity.
	}
	
}


