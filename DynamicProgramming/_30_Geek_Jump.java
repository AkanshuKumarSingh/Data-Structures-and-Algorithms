package DynamicProgramming;

import java.util.Arrays;

public class _30_Geek_Jump {

	public int solve(int arr[], int idx, int n, int dp[]) {
		if (idx == n - 1)
			return 0;
		if (dp[idx] != -1)
			return dp[idx];
		int ans = Math.abs(arr[idx + 1] - arr[idx]) + solve(arr, idx + 1, n, dp);
		if (idx + 2 <= n - 1) {
			ans = Math.min(ans, Math.abs(arr[idx + 2] - arr[idx]) + solve(arr, idx + 2, n, dp));
		}
		return dp[idx] = ans;
	}

	public int minimumEnergy(int arr[], int n) {
		int dp[] = new int[n + 1];
		Arrays.fill(dp, -1);
		for (int i = n - 1; i >= 0; i--) {
			if (i == n - 1) {
				dp[i] = 0;
			} else {
				int ans = dp[i + 1] + Math.abs(arr[i] - arr[i + 1]);
				if (i + 2 <= n - 1) {
					ans = Math.min(ans, Math.abs(arr[i + 2] - arr[i]) + dp[i + 2]);
				}
				dp[i] = ans;
			}
		}
		return dp[0];
	}

}
