package DynamicProgramming;

public class _13_Longest_Common_Substring {

	static String X = "abcdxyz";
	static String Y = "xyzabcd";
	static int longestCommonSubstr(int i, int j, int count) {

		if (i == 0 || j == 0) {
			return count;
		}

		if (X.charAt(i - 1) == Y.charAt(j - 1)) {
			count = longestCommonSubstr(i - 1, j - 1, count + 1);
		}
		count = Math.max(count, Math.max(longestCommonSubstr(i, j - 1, 0), longestCommonSubstr(i - 1, j, 0)));
		return count;
	}

	int longestCommonSubstrTabulation(String s1, String s2, int n, int m) {
		int t[][] = new int[n + 1][m + 1];
		int ans = 0;

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else {
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						t[i][j] = 1 + t[i - 1][j - 1];
						ans = Math.max(ans, t[i][j]);
					} else {
						t[i][j] = 0;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String args[]) {

		System.out.println(longestCommonSubstr(X.length(), Y.length(), 0));
	}

}
