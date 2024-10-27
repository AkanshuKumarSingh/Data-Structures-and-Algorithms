package DynamicProgramming;

import java.util.Arrays;

public class _51_Longest_Increasing_Subsequence {

	public int lengthOfLIS2(int[] nums) {
		int n = nums.length;
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], 1+dp[j]);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}

	public int lengthOfLIS1(int[] nums) {
		int n = nums.length;
		int dp[][] = new int[n + 1][n + 1];
		for (int i = n; i >= 0; i--)
			for (int j = n - 1; j >= -1; j--) {
				if (i == n)
					dp[i][j + 1] = 0;
				else {
					int val = dp[i + 1][j + 1];
					if (j == -1 || nums[i] > nums[j]) {
						val = Math.max(val, 1 + dp[i + 1][i + 1]);
					}
					dp[i][j + 1] = val;
				}
			}
		return dp[0][0];
	}

	public int fxn(int i, int n, int prev_idx, int nums[], int dp[][]) {
		if (i == n)
			return 0;
		if (dp[i][prev_idx + 1] != -1)
			return dp[i][prev_idx + 1];

		int val = fxn(i + 1, n, prev_idx, nums, dp);
		if (prev_idx == -1 || nums[i] > nums[prev_idx]) {
			val = Math.max(val, 1 + fxn(i + 1, n, i, nums, dp));
		}
		return dp[i][prev_idx + 1] = val;
	}

	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int dp[][] = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], -1);

		return fxn(0, n, -1, nums, dp);
	}
}
