package Time_and_space;

import java.util.Arrays;
import java.util.Scanner;

public class Sieve_of_Eratosthenes {

	public static void sieve(int arr[], int range) {
		boolean isPrime[] = new boolean[range + 1];
	
		Arrays.fill(isPrime, true);
		
		for (int i = 2; i * i <= range; i++) {
			if(isPrime[i] == false) continue;
			for(int j = i+i; j <= range; j += i) {
				isPrime[j] = false;
			}
		}
		
		
		for(int i = 0; i < arr.length; i++) {
			if(isPrime[arr[i]] == true) {
				System.out.println(arr[i] + " is Prime");
			}else {
				System.out.println(arr[i] + " is not Prime");
			}
		}
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		
		int range = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
			range = Math.max(range, arr[i]);
		}
		sieve(arr, range);
	}

}
