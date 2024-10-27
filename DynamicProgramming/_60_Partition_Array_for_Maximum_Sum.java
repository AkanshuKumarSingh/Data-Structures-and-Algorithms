package DynamicProgramming;

import java.util.Arrays;

public class _60_Partition_Array_for_Maximum_Sum {

	public int maxSumAfterPartitioning1(int[] arr, int k) {
		int n = arr.length;
		int dp[] = new int[n + 1];
		for (int i = n; i >= 0; i--) {
			if (i == n)
				dp[i] = 0;
			else {
				int max = Integer.MIN_VALUE;
				int ans = Integer.MIN_VALUE;
				for (int j = i; j < i + k && j < n; j++) {
					max = Math.max(max, arr[j]);
					ans = Math.max(ans, max * (j - i + 1) + dp[j + 1]);
				}
				dp[i] = ans;
			}
		}
		return dp[0];
	}

	public int fxn(int i, int n, int k, int arr[], int dp[]) {
		if (i == n)
			return 0;
		if (dp[i] != -1)
			return dp[i];

		int max = Integer.MIN_VALUE;
		int ans = Integer.MIN_VALUE;
		for (int j = i; j < i + k && j < n; j++) {
			max = Math.max(max, arr[j]);
			ans = Math.max(ans, max * (j - i + 1) + fxn(j + 1, n, k, arr, dp));
		}
		return dp[i] = ans;
	}

	public int maxSumAfterPartitioning(int[] arr, int k) {
		int n = arr.length;
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		return fxn(0, n, k, arr, dp);
	}

}
