package DynamicProgramming;

public class _21_Sequence_Pattern_Matching {

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

    public boolean isSubsequence(String s, String t) {
        if(lcsTabulation(s.length(), t.length(), s, t) == s.length()) return true;
        else return false;
    }
	
}
