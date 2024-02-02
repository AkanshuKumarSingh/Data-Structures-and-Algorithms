package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class Partition_Into_Subsets {
	
	public static int[] find(int b[]) {
		
		int a[] = new int[b.length];
		a[0] = b[0];
		for(int i = 1; i < a.length; i++) {
			a[i] = b[i] ^ b[i-1];
		}
		return a;
	}

	public static long partitionTabulation(int n, int k) {
		long dp[][] = new long[k + 1][n + 1];

		// f(n,k) = k*f(n-1,k) + f(n-1,k-1)
		for (int i = 1; i <= k; i++) {
			for (int j = i; j <= n; j++) {
				if(i == j) {
					dp[i][j] = 1;
				}else{
					dp[i][j] = i*dp[i][j-1] + dp[i-1][j-1];
				}
			}
		}
		return dp[k][n];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		int n = scan.nextInt();
//		int k = scan.nextInt();
////		long res = partitionTabulation(n, k);
		ArrayList<Integer> l = new ArrayList<>();
		l.add(3);
		l.add(1);
		System.out.println(l.get(0)^l.get(1));
		int ans[] = find(new int[] {2, 2, 5, 6});
		for(int a: ans) {
			System.out.println(a);
		}
		
	}

}
