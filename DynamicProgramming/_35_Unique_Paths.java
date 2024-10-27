package DynamicProgramming;

public class _35_Unique_Paths {

	public int uniquePaths1(int m, int n) {
		int dp[][] = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					dp[i][j] = 1;
				} else if (i == m - 1) {
					dp[i][j] = dp[i][j + 1];
				} else if (j == n - 1) {
					dp[i][j] = dp[i + 1][j];
				} else {
					dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
				}
			}
		}
		return dp[0][0];
	}

	public int solve(int i, int j, int m, int n, boolean dp[][]) {
		if (i == m - 1 && j == n - 1)
			return 1;

		dp[i][j] = true;
		int ans = 0;
		if (i + 1 < m && !dp[i + 1][j]) {
			ans = solve(i + 1, j, m, n, dp);
		}
		if (j + 1 < n && !dp[i][j + 1]) {
			ans += solve(i, j + 1, m, n, dp);
		}
		dp[i][j] = false;
		return ans;
	}

	public int uniquePaths(int m, int n) {
		boolean dp[][] = new boolean[m][n];
		int ans = solve(0, 0, m, n, dp);
		return ans;
	}

}