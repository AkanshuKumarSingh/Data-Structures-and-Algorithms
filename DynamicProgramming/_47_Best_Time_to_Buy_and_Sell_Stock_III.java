package DynamicProgramming;

import java.util.Arrays;

public class _47_Best_Time_to_Buy_and_Sell_Stock_III {

	public int maxProfit1(int[] prices) {
		int n = prices.length;
		int dp[][][] = new int[n + 1][2][3];
		for (int i = n; i >= 0; i--) {
			for (int j = 0; j < 2; j++) {
				for(int k = 2; k >= 0; k--) {
					if (i == n) {
						dp[i][j][k] = 0;
					}else if(k == 2) {
						dp[i][j][k] = 0;
					}else if (j == 0) {
						dp[i][j][k] = Math.max(-1 * prices[i] + dp[i + 1][1][k], dp[i + 1][0][k]);
					} else {
						dp[i][j][k] = Math.max(prices[i] + dp[i + 1][0][k+1], dp[i + 1][1][k]);
					}
				}
			}
		}
		return dp[0][0][0];
	}

	public int fxn(int i, int j, int n, int prices[], int cap, int dp[][][]) {
		if (i == n)
			return 0;
		if (cap == 2)
			return 0;
		if (dp[i][j][cap] != -1)
			return dp[i][j][cap];

		if (j == 0) {
			return dp[i][j][cap] = Math.max(-1 * prices[i] + fxn(i + 1, 1, n, prices, cap, dp),
					fxn(i + 1, 0, n, prices, cap, dp));
		} else {
			return dp[i][j][cap] = Math.max(prices[i] + fxn(i + 1, 0, n, prices, cap + 1, dp),
					fxn(i + 1, 1, n, prices, cap, dp));
		}
	}

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int dp[][][] = new int[n + 1][2][3];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j < 2; j++)
				Arrays.fill(dp[i][j], -1);
		return fxn(0, 0, n, prices, 0, dp);
	}

}
