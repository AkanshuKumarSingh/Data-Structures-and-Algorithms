package DynamicProgramming;

public class _16_Minimum_number_of_deletions_and_insertions {

	public int lcsTabulation(int n, int m, String s1, String s2) {
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

	public int minOperations(String str1, String str2) {
		int lcs = lcsTabulation(str1.length(), str2.length(), str1, str2);
		return str1.length() - lcs + str2.length() - lcs;
	}
}
