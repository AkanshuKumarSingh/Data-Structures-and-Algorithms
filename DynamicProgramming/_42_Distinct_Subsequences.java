package DynamicProgramming;

import java.util.Arrays;

public class _42_Distinct_Subsequences {

	public int numDistinct1(String s, String t) {
		int n = s.length(), m = t.length();
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (j == 0)
					dp[i][j] = 1;
				else if (i == 0)
					dp[i][j] = 0;
				else if (s.charAt(i - 1) == t.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][m];
	}

	public int fxn(int n, int m, String s, String t, int dp[][]) {
		if (m == 0)
			return 1;
		if (n == 0)
			return 0;
		if (dp[n][m] != -1)
			return dp[n][m];

		if (s.charAt(n - 1) == t.charAt(m - 1)) {
			return dp[n][m] = fxn(n - 1, m - 1, s, t, dp) + fxn(n - 1, m, s, t, dp);
		} else {
			return dp[n][m] = fxn(n - 1, m, s, t, dp);
		}

	}

	public int numDistinct(String s, String t) {
		int n = s.length(), m = t.length();
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		return fxn(n, m, s, t, dp);
	}

}
