package DynamicProgramming;

import java.util.Arrays;

public class _32_House_Robber {

	public int solve(int arr[], int i, int n, int dp[]) {
		if (i >= n)
			return 0;
		if (dp[i] != -1)
			return dp[i];
		int ans = arr[i] + solve(arr, i + 2, n, dp);
		if (i < n - 1) {
			ans = Math.max(ans, arr[i + 1] + solve(arr, i + 3, n, dp));
		}
		return dp[i] = ans;
	}

	public int rob(int[] nums) {
		int dp[] = new int[nums.length + 1];
		Arrays.fill(dp, -1);
		solve(nums, 0, nums.length, dp);
		return dp[0];
	}

}
