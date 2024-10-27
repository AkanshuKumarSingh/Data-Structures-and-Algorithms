package DynamicProgramming;

import java.util.Arrays;

public class _57_Number_of_Longest_Increasing_Subsequence {

	public int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		int dp[] = new int[n], cnt[] = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(cnt, 1);
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					cnt[i] = cnt[j];
				} else if (dp[i] == dp[j] + 1) {
					cnt[i] += cnt[j];
				}
			}
			ans = Math.max(ans, dp[i]);
		}

		int maxCnt = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] == ans)
				maxCnt += cnt[i];
		}

		return maxCnt;
	}

}
