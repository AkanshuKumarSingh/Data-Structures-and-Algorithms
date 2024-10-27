package DynamicProgramming;

import java.util.*;

public class _52_Print_Longest_Increasing_Subsequence {

	public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {

		int dp[] = new int[n];
		int idx[] = new int[n];
		int ans = 0, lastIdx = -1;
		Arrays.fill(dp, 1);

		for (int i = 0; i < n; i++) {
			idx[i] = i;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					idx[i] = j;
				}
			}
			if (ans < dp[i]) {
				ans = dp[i];
				lastIdx = i;
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		while (idx[lastIdx] != lastIdx) {
			list.add(arr[lastIdx]);
			lastIdx = idx[lastIdx];
		}
		list.add(arr[lastIdx]);
		Collections.reverse(list);
		return list;
	}

}
