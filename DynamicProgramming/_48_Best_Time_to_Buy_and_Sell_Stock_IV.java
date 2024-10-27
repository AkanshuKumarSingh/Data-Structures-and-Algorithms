package DynamicProgramming;

public class _48_Best_Time_to_Buy_and_Sell_Stock_IV {

	public int maxProfit(int k1, int[] prices) {
		int n = prices.length;
		int dp[][][] = new int[n + 1][2][k1 + 1];
		for (int i = n; i >= 0; i--) {
			for (int j = 0; j < 2; j++) {
				for (int k = k1; k >= 0; k--) {
					if (i == n) {
						dp[i][j][k] = 0;
					} else if (k == k1) {
						dp[i][j][k] = 0;
					} else if (j == 0) {
						dp[i][j][k] = Math.max(-1 * prices[i] + dp[i + 1][1][k], dp[i + 1][0][k]);
					} else {
						dp[i][j][k] = Math.max(prices[i] + dp[i + 1][0][k + 1], dp[i + 1][1][k]);
					}
				}
			}
		}
		return dp[0][0][0];
	}

}
