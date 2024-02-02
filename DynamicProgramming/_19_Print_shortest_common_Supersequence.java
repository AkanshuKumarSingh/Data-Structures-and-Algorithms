package DynamicProgramming;

public class _19_Print_shortest_common_Supersequence {

	public String shortestCommonSupersequence(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
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

		StringBuilder str = new StringBuilder();
		int i = n, j = m;
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				str.append(s1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (t[i - 1][j] > t[i][j - 1]) {
					str.append(s1.charAt(i - 1));
					i--;
				} else {
					str.append(s2.charAt(j - 1));
					j--;
				}
			}
		}

		while (i > 0) {
			str.append(s1.charAt(i - 1));
			i--;
		}

		while (j > 0) {
			str.append(s2.charAt(j - 1));
			j--;
		}

		return str.reverse().toString();
	}

}
