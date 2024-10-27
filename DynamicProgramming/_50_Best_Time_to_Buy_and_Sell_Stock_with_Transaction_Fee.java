package DynamicProgramming;

import java.util.Arrays;

public class _50_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

	public int maxProfit1(int[] prices, int fee) {
		int n = prices.length;
		int dp[][] = new int[n + 1][2];
		for (int i = n; i >= 0; i--) {
			for (int j = 0; j < 2; j++) {
				if (i == n) {
					dp[i][j] = 0;
				} else if (j == 0) {
					dp[i][j] = Math.max(-1 * prices[i] + dp[i + 1][1], dp[i + 1][0]);
				} else {
					dp[i][j] = Math.max(prices[i] - fee + dp[i + 1][0], dp[i + 1][1]);
				}
			}
		}
		return dp[0][0];
	}

	
	public int fxn(int i, int j, int n, int prices[], int dp[][], int fee) {
		if (i == n)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];

		if (j == 0) {
			return dp[i][j] = Math.max(-1 * prices[i] + fxn(i + 1, 1, n, prices, dp, fee),
					fxn(i + 1, 0, n, prices, dp, fee));
		} else {
			return dp[i][j] = Math.max(prices[i] - fee + fxn(i + 1, 0, n, prices, dp, fee),
					fxn(i + 1, 1, n, prices, dp, fee));
		}
	}

	public int maxProfit(int[] prices, int fee) {
		int n = prices.length;
		int dp[][] = new int[n + 1][2];
		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], -1);
		return fxn(0, 0, n, prices, dp, fee);
	}

}
