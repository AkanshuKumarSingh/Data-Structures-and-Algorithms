package DynamicProgramming;

import java.util.Arrays;

public class _33_House_Robber_II {

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
        if(nums.length == 1) return nums[0];
		int dp[] = new int[nums.length + 1];
		Arrays.fill(dp, -1);
		int ans1 = solve(nums, 0, nums.length-1, dp);
		Arrays.fill(dp, -1);
		int ans2 = solve(nums, 1, nums.length, dp);
		return Math.max(ans1, ans2);
	}

	public int solve1(int arr[], int i, int n, int dp[][], int flag) {
		if (i == n - 1 && flag == 1)
			return 0;
		if (i >= n)
			return 0;
		if (dp[i][flag] != -1)
			return dp[i][flag];

		int ans = arr[i] + solve1(arr, i + 2, n, dp, flag);
		if (i < n - 1 && !(i + 1 == n - 1 && flag == 1)) {
			ans = Math.max(ans, arr[i + 1] + solve1(arr, i + 3, n, dp, flag));
		}
		return dp[i][flag] = ans;
	}

	public int rob1(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		if (n == 2)
			return Math.max(nums[0], nums[1]);

		int dp[][] = new int[nums.length + 1][2];
		for (int i = 0; i < nums.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		int ans = Math.max(nums[0] + solve1(nums, 2, nums.length, dp, 1),
				Math.max(nums[1] + solve1(nums, 3, nums.length, dp, 0), solve1(nums, 2, nums.length, dp, 0)));
		return ans;
	}

}
