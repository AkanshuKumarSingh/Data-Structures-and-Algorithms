package Array;

import java.util.Scanner;

public class _8_SubArray_Problem {
//	1. You are given an array of size 'n' and n elements of the same array.
//	2. You are required to find and print all the subarrays of the given array. 
//	3. Each subarray should be space seperated and on a seperate lines. Refer to sample input and output.
//	Sample Input
//	3
//	10
//	20
//	30
//	Sample Output
//	10	
//	10	20	
//	10	20	30	
//	20	
//	20	30	
//	30	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
//		Time complexity is O(n3) and total subarray are n(n+1)/2
		
//		for(int i = 0 ; i < n; i++) {
//			String ans = "" + arr[i];
//			System.out.println(ans);
//			for(int j  = i+1 ; j < n; j++) {
//				ans += ("\t" + arr[j]);
//				System.out.println(ans);
//			}
//		}
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0; j < n-i; j++) {
				for(int k = 0 ; k <= j ; k++) {
					System.out.print(arr[k+i] + "\t");
				}
				System.out.println();
			}
		}
		
		System.out.println("\n");
		
//		python code
//		for i in range(n):
//		    for j in range(i, n):
//		        for k in range(i, j+1):
//		            print(arr[k])
//		        print()

		
	}

}
