package DynamicProgramming;

import java.util.Arrays;

public class _24_Palindromic_Partitioning {

	static boolean isPalindrome(String str, int i, int j) {
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	static int partitionIntoPalindromeStrTabulation(String str) {
		int n = str.length();
		int dp[][] = new int[n+1][n];
		for(int i = n; i >= 0; i--) {
			for(int j = 0; j < n; j++) {
				if(i >= j) dp[i][j] = 0;
				else if(isPalindrome(str, i, j))dp[i][j] = 0;
				else {
					int ans = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int count = dp[i][k] + dp[k+1][j] + 1;
						ans = Math.min(ans, count);
					}
					dp[i][j] = ans;
				}
			}
		}
		return dp[0][n-1];
	}

	static int partitionIntoPalindromeStr(String str, int i, int j) {
		if (i >= j)
			return 0;

		if (isPalindrome(str, i, j))
			return 0;

		int ans = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int count = partitionIntoPalindromeStr(str, i, k) + partitionIntoPalindromeStr(str, k + 1, j) + 1;
			ans = Math.min(ans, count);
		}
		System.out.println(ans);
		return ans;
		
//		Using Recursion – O(n * 2^n) Time and O(n) Space

	}

	static int t[][];

	static int partitionIntoPalindromeStrMemoization(String str, int i, int j) {
		if (i >= j)
			return t[i][j] = 0;
		if (t[i][j] != -1)
			return t[i][j];
		if (isPalindrome(str, i, j))
			return t[i][j] = 0;

		int ans = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int count = partitionIntoPalindromeStrMemoization(str, i, k)
					+ partitionIntoPalindromeStrMemoization(str, k + 1, j) + 1;
			ans = Math.min(ans, count);
		}
		return t[i][j] = ans;
	}

	static int palindromicPartition(String str) {
		int n = str.length();
		t = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(t[i], -1);
		}
		return partitionIntoPalindromeStrMemoization(str, 0, str.length() - 1);
	}

}
