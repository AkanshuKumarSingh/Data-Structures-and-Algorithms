package DynamicProgramming;

import java.util.*;

public class _39_Minimum_Falling_Path_Sum {

	public int minFallingPathSum1(int[][] matrix) {
		int n = matrix.length, ans = Integer.MAX_VALUE;
		int dp[][] = new int[n + 1][n];
		for (int i = n; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (i == n)
					dp[i][j] = 0;
				else {
					ans = Integer.MAX_VALUE;
					if (j - 1 >= 0) {
						ans = dp[i + 1][j - 1];
					}
					ans = Math.min(ans, dp[i + 1][j]);
					if (j + 1 < n) {
						ans = Math.min(ans, dp[i + 1][j + 1]);
					}
					dp[i][j] = ans + matrix[i][j];
				}
			}
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			res = Math.min(res, dp[0][i]);
		}
		return res;
	}

	public int solve(int arr[][], int i, int j, int n, int dp[][]) {
		if (i == n)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];

		int ans = Integer.MAX_VALUE;
		if (j - 1 >= 0) {
			ans = solve(arr, i + 1, j - 1, n, dp);
		}
		ans = Math.min(ans, solve(arr, i + 1, j, n, dp));
		if (j + 1 < n) {
			ans = Math.min(ans, solve(arr, i + 1, j + 1, n, dp));
		}
		return dp[i][j] = ans + arr[i][j];
	}

	public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length, ans = Integer.MAX_VALUE;
		int dp[][] = new int[n + 1][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < n; i++) {
			ans = Math.min(ans, solve(matrix, 0, i, n, dp));
		}
		return ans;
	}

}
