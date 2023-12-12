package DynamicProgramming;

import java.util.Scanner;

public class ClimbStairsWithVariableJumps {

	public static int csRecursive(int i, int n, int arr[]) {
		if(i == n) {
			return 1;
		}
		
		int cnt = 0;
		for(int jump = 1; jump <= arr[i] && i+jump <= n; jump++) {
			cnt += (csRecursive(i+jump,n,arr));
		}
		
		return cnt;
	}
	
	public static int csMemoized(int i, int n, int arr[], int dp[]) {
		if(i == n) {
			return 1;
		}
		
		if(dp[i] != 0) return dp[i];
		
		int cnt = 0;
		for(int jump = 1; jump <= arr[i] && i+jump <= n; jump++) {
			cnt += (csMemoized(i+jump,n,arr,dp));
		}
		
		dp[i] = cnt;
		
		return cnt;
	}
	
	public static int csTabulation(int i, int n,int arr[], int dp[]) {
		// made	from memoized code
		for (i = n; i >= 0; i--) {
			if (i == n) {
				dp[i] = 1;
				continue;
			}
			int count = 0;
			for (int jump = 1; jump <= arr[i] && jump + i <= n; jump++) {
				count += dp[i + jump];
			}
			dp[i] = count;
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i = 0 ; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println(csRecursive(0,n,arr));
		System.out.println(csMemoized(0,n,arr,new int[n+1]));
		System.out.println(csTabulation(0,n,arr,new int[n+1]));

	}

}
