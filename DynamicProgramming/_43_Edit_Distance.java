package DynamicProgramming;

import java.util.Arrays;

public class _43_Edit_Distance {

    public int minDistance1(String word1, String word2) {
		int n = word1.length(), m = word2.length();
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				if(i == 0) dp[i][j] = j;
				else if(j == 0) dp[i][j] = i;
				else {
					if(word1.charAt(i-1) == word2.charAt(j-1)) {
						dp[i][j] = dp[i-1][j-1];
					}else {
						dp[i][j] = Math.min(dp[i-1][j] + 1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+1));
					}
				}
			}
		}
		return dp[n][m];
    }

	int fxn(int n, int m, String s1, String s2, int dp[][]) {
		if (n == 0)
			return m;
		if (m == 0)
			return n;
		if (dp[n][m] != -1)
			return dp[n][m];

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return dp[n][m] = fxn(n - 1, m - 1, s1, s2, dp);
		} else {
			int val1 = fxn(n - 1, m, s1, s2, dp) + 1;
			int val2 = fxn(n, m - 1, s1, s2, dp) + 1;
			int val3 = fxn(n - 1, m - 1, s1, s2, dp) + 1;
			return dp[n][m] = Math.min(val1, Math.min(val2, val3));
		}
	}

	public int minDistance(String word1, String word2) {
		int n = word1.length(), m = word2.length();
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		return fxn(n, m, word1, word2, dp);
	}

}
