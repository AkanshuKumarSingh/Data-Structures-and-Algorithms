package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class _59_Burst_Balloons {

	public int maxCoins1(int[] nums) {
		int n = nums.length;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		for (int no : nums)
			list.add(no);
		list.add(1);

		int dp[][] = new int[n + 2][n + 1];
		for (int i = n + 1; i >= 1; i--) {
			for (int j = 0; j <= n; j++) {
				if (i > j)
					dp[i][j] = 0;
				else {
					int max = Integer.MIN_VALUE;
					for (int k = i; k <= j; k++) {
						int cost = list.get(i - 1) * list.get(k) * list.get(j + 1) + dp[i][k - 1] + dp[k + 1][j];
						max = Math.max(max, cost);
					}
					dp[i][j] = max;
				}
			}
		}

		return dp[1][nums.length];

	}

	public int fxn(int i, int j, ArrayList<Integer> nums, int dp[][]) {
		if (i > j)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];

		int max = Integer.MIN_VALUE;
		for (int k = i; k <= j; k++) {
			int cost = nums.get(i - 1) * nums.get(k) * nums.get(j + 1) + fxn(i, k - 1, nums, dp)
					+ fxn(k + 1, j, nums, dp);
			max = Math.max(max, cost);
		}
		return dp[i][j] = max;
	}

	public int maxCoins(int[] nums) {
		int n = nums.length;
		ArrayList<Integer> list = new ArrayList<>();
		int dp[][] = new int[n + 2][n + 1];
		for (int i = 0; i < n + 2; i++)
			Arrays.fill(dp[i], -1);

		list.add(1);
		for (int no : nums)
			list.add(no);
		list.add(1);
		return fxn(1, nums.length, list, dp);
	}

}
