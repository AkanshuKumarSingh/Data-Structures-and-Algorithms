package DynamicProgramming;

import java.util.*;

public class _54_Largest_Divisible_Subset {

	public List<Integer> largestDivisibleSubset(int[] nums) {
		int n = nums.length;
		int dp[] = new int[n];
		int idx[] = new int[n];
		Arrays.sort(nums);
		int ans = 0, lastIdx = -1;
		Arrays.fill(dp, 1);

		for (int i = 0; i < n; i++) {
			idx[i] = i;
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
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
			list.add(nums[lastIdx]);
			lastIdx = idx[lastIdx];
		}
		list.add(nums[lastIdx]);
		Collections.reverse(list);
		return list;
	}
	
}
