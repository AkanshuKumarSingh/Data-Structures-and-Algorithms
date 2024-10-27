package DynamicProgramming;

import java.util.Arrays;

public class _44_Wildcard_Matching {

	public boolean isMatch1(String s2, String s1) {
		int n = s1.length(), m = s2.length();
		boolean dp[][] = new boolean[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = true;
				}else if(i == 0) {
					dp[i][j] = false;
				}else if(j == 0) {
					dp[i][j] = true;
					for (int i1 = 0; i1 < i; i1++) {
						if (s1.charAt(i1) != '*') {
							dp[i][j] = false;
							break;
						}
					}
				}else {
					if(s1.charAt(i-1) == s2.charAt(j-1)) {
						dp[i][j] = dp[i-1][j-1];
					}else if(s1.charAt(i-1) == '?') {
						dp[i][j] = dp[i-1][j-1];
					}else if(s1.charAt(i-1) == '*') {
						dp[i][j] = dp[i-1][j] || dp[i][j-1];
					}else {
						dp[i][j] = false;
					}
				}
			}
		}
		return dp[n][m];
	}

	public boolean fxn(int n, int m, String s1, String s2, int dp[][]) {
		if (n == 0 && m == 0)
			return true;
		if (n == 0)
			return false;
		if (m == 0) {
			for (int i = 0; i < n; i++) {
				if (s1.charAt(i) != '*')
					return false;
			}
			return true;
		}
		if (dp[n][m] != -1)
			return dp[n][m] == 0 ? false : true;

		boolean val;
		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			val = fxn(n - 1, m - 1, s1, s2, dp);
		} else if (s1.charAt(n - 1) == '?') {
			val = fxn(n - 1, m - 1, s1, s2, dp);
		} else if (s1.charAt(n - 1) == '*') {
			val = fxn(n - 1, m, s1, s2, dp) || fxn(n, m - 1, s1, s2, dp);
		} else {
			val = false;
		}
		dp[n][m] = val ? 1 : 0;
		return val;
	}

	public boolean isMatch(String s, String p) {
		int n = p.length(), m = s.length();
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		return fxn(n, m, p, s, dp);
	}

}
