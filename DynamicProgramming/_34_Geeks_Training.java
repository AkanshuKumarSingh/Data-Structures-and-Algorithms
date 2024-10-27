package DynamicProgramming;

public class _34_Geeks_Training {

	public int maximumPoints(int arr[][], int N) {
		int dp[][] = new int[N + 1][3];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 0) {
					dp[i][j] = 0;
				} else {
					if (j == 0) {
						dp[i][j] = arr[i - 1][j] + Math.max(dp[i - 1][1], dp[i - 1][2]);
					} else if (j == 1) {
						dp[i][j] = arr[i - 1][j] + Math.max(dp[i - 1][0], dp[i - 1][2]);
					} else {
						dp[i][j] = arr[i - 1][j] + Math.max(dp[i - 1][0], dp[i - 1][1]);
					}
				}
			}
		}
		return Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2]));
	}

}
