package DynamicProgramming;

public class _45_Best_Time_to_Buy_and_Sell_Stock {

	public int maxProfit(int[] prices) {
		int minTillNow = prices[0];
		int ans = 0;
		for (int i = 1; i < prices.length; i++) {
			ans = Math.max(ans, prices[i] - minTillNow);
			minTillNow = Math.min(prices[i], minTillNow);
		}
		return ans;
	}

}
