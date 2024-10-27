package DynamicProgramming;

import java.util.Arrays;

public class _41_Assign_Cookies {

	public int findContentChildren(int[] g, int[] s) {
		int n = g.length, m = s.length, ans = 0;
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0, j = 0;
		while (i < n && j < m) {
			if (g[i] <= s[j]) {
				j++;
				i++;
				ans++;
			} else {
				j++;
			}
		}
		return ans;
	}

}
