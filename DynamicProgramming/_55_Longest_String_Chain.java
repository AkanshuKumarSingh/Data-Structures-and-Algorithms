package DynamicProgramming;

import java.util.*;

public class _55_Longest_String_Chain {
	
	public boolean compare(String s1, String s2) {
		int n = s1.length(), m = s2.length(), i = 0, j = 0;
		if (n - m != 1)
			return false;
		while (i < n && j < m) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
			}
		}
		return (i == n || i == n - 1) && j == m;
	}

	public int longestStrChain(String[] words) {
		int n = words.length;
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		int ans = 0;
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (compare(words[i], words[j]) && dp[i] < dp[j] + 1) {
					dp[i] = 1 + dp[j];
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;

	}

}
