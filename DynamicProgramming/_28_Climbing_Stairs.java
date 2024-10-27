package DynamicProgramming;

import java.util.Arrays;

public class _28_Climbing_Stairs {

	public int solve(int n, int dp[]) {
		if (n == 0)
			return dp[n] = 1;
		if (dp[n] != -1)
			return dp[n];

		int ans = solve(n - 1, dp);
		if (n - 2 >= 0) {
			ans += solve(n - 2, dp);
		}
		return dp[n] = ans;
	}

	public int climbStairs(int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		solve(n, dp);
		return dp[n];
	}

}
