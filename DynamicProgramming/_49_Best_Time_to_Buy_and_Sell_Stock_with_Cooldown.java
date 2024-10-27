package DynamicProgramming;

public class _49_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int dp[][] = new int[n + 2][2];
		for (int i = n; i >= 0; i--) {
			for (int j = 0; j < 2; j++) {
				if (i >= n) {
					dp[i][j] = 0;
				} else if (j == 0) {
					dp[i][j] = Math.max(-1 * prices[i] + dp[i + 1][1], dp[i + 1][0]);
				} else {
					dp[i][j] = Math.max(prices[i] + dp[i + 2][0], dp[i + 1][1]);
				}
			}
		}
		return dp[0][0];
	}

}
