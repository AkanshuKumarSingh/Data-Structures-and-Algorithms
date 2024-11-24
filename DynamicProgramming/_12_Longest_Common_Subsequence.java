package DynamicProgramming;

import java.util.Arrays;

public class _12_Longest_Common_Subsequence {

	static int lcsRecursive(int n, int m, String s1, String s2) {
		if (n == 0 || m == 0) {
			return 0;
		}

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return 1 + lcsRecursive(n - 1, m - 1, s1, s2);
		} else {
			return Math.max(lcsRecursive(n - 1, m, s1, s2), lcsRecursive(n, m - 1, s1, s2));
		}

//		For each of the n + m steps, there are potentially two choices (branches). 
//		This leads to approximately 2^(n + m) combinations of recursive calls in the worst case, 
//		where the function explores all possible subsequences of the two strings.
//		
//		The time complexity of this recursive solution is O(2^(n + m)).
//		The space complexity of this recursive solution is O(n + m).


	}

	static int t[][];

	static int lcsMemoization(int n, int m, String s1, String s2) {
		if (n == 0 || m == 0) {
			return t[n][m] = 0;
		}

		if (t[n][m] != -1)
			return t[n][m];

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return t[n][m] = 1 + lcsMemoization(n - 1, m - 1, s1, s2);
		} else {
			return t[n][m] = Math.max(lcsMemoization(n - 1, m, s1, s2), lcsMemoization(n, m - 1, s1, s2));
		}
	}

	static int lcs(int n, int m, String s1, String s2) {
		t = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(t[i], -1);
		}
		return lcsMemoization(n, m, s1, s2);
	}

	static int lcsTabulation(int n, int m, String s1, String s2) {
		int t[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else {
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						t[i][j] = 1 + t[i - 1][j - 1];
					} else {
						t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
					}
				}
			}
		}
		return t[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
