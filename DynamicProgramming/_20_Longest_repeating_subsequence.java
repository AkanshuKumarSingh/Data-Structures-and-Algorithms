package DynamicProgramming;

public class _20_Longest_repeating_subsequence {

	public int LongestRepeatingSubsequence(String str) {
		int n = str.length();
		int t[][] = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else {
					if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
						t[i][j] = 1 + t[i - 1][j - 1];
					} else {
						t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
					}
				}
			}
		}
		return t[n][n];
	}

}
