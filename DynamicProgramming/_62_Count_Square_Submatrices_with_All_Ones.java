package DynamicProgramming;

public class _62_Count_Square_Submatrices_with_All_Ones {

	public int countSquares(int[][] arr) {
		int n = arr.length, m = arr[0].length;
		int dp[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = arr[i][j];
				else {
					if (arr[i][j] == 0)
						dp[i][j] = 0;
					else {
						dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
					}
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum += dp[i][j];
			}
		}

		return sum;
	}

}
