package DynamicProgramming;

import java.util.Arrays;

public class _40_Chocolates_Pickup {

	public int solve1(int n, int m, int grid[][]) {
		int dp[][][] = new int[n + 1][m][m];
		for (int i = n; i >= 0; i--) {
			for (int j1 = 0; j1 < m; j1++) {
				for (int j2 = 0; j2 < m; j2++) {
					if (i == n) {
						dp[i][j1][j2] = 0;
						continue;
					}
					int ans = Integer.MIN_VALUE;
					for (int p1 = -1; p1 <= 1; p1++) {
						for (int p2 = -1; p2 <= 1; p2++) {
							int nj1 = j1 + p1;
							int nj2 = j2 + p2;
							int val = 0;
							if (nj1 < 0 || nj1 >= m || nj2 < 0 || nj2 >= m) {
								continue;
							} else if (j1 == j2) {
								val = grid[i][j2] + dp[i + 1][nj1][nj2];
							} else {
								val = grid[i][j1] + grid[i][j2] + dp[i + 1][nj1][nj2];
							}
							ans = Math.max(ans, val);
						}
					}
					dp[i][j1][j2] = ans;
				}
			}
		}

		return dp[0][0][m - 1];

	}

	public int findSol(int i, int j1, int j2, int n, int m, int grid[][], int dp[][][]) {
		if (i == n)
			return 0;
		if (dp[i][j1][j2] != -1)
			return dp[i][j1][j2];

		int ans = Integer.MIN_VALUE;
		for (int p1 = -1; p1 <= 1; p1++) {
			for (int p2 = -1; p2 <= 1; p2++) {
				int nj1 = j1 + p1;
				int nj2 = j2 + p2;
				int val = 0;
				if (nj1 < 0 || nj1 >= m || nj2 < 0 || nj2 >= m) {
					continue;
				} else if (j1 == j2) {
					val = grid[i][j2] + findSol(i + 1, nj1, nj2, n, m, grid, dp);
				} else {
					val = grid[i][j1] + grid[i][j2] + findSol(i + 1, nj1, nj2, n, m, grid, dp);
				}
				ans = Math.max(ans, val);
			}
		}

		return dp[i][j1][j2] = ans;
	}

	public int solve(int n, int m, int grid[][]) {
		int dp[][][] = new int[n + 1][m][m];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		return findSol(0, 0, m - 1, n, m, grid, dp);
	}

}
