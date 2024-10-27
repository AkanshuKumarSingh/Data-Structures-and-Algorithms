package DynamicProgramming;

import java.util.Arrays;

public class _31_Minimal_Cost {

	public int minimizeCost(int k, int arr[]) {
		int n = arr.length;
		int dp[] = new int[n + 1];

		Arrays.fill(dp, -1);
		for (int i = n - 1; i >= 0; i--) {
			if (i == n - 1) {
				dp[i] = 0;
			} else {
				int ans = Integer.MAX_VALUE;
				for (int j = 1; j <= k && i + j < n; j++) {
					ans = Math.min(ans, dp[i + j] + Math.abs(arr[i] - arr[i + j]));
				}
				dp[i] = ans;
			}
		}
		return dp[0];
	}

}
