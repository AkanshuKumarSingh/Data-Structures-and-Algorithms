package DynamicProgramming;

import java.util.*;

public class _38_Triangle {

	public int minimumTotal1(List<List<Integer>> triangle) {
		int n = triangle.size();
		int m = triangle.get(n - 1).size();
		int dp[][] = new int[n + 1][m + 1];
		for (int i = n; i >= 0; i--) {
			for (int j = m; j >= 0; j--) {
				if (i == n)
					dp[i][j] = 0;
				else if (j > i) // imp condition if absent gives error
					continue;
				else {
					List<Integer> ele = triangle.get(i);
					int ans = dp[i + 1][j];
					ans = Math.min(ans, dp[i + 1][j + 1]);
					dp[i][j] = ele.get(j) + ans;
				}
			}
		}
		return dp[0][0];
	}

	public int solve(List<List<Integer>> triangle, int i, int j, int dp[][]) {
		if (i == triangle.size()) {
			return 0;
		}else if(dp[i][j] != -1){
            return dp[i][j];
        }

		List<Integer> ele = triangle.get(i);
		int ans = solve(triangle, i + 1, j, dp);
        ans = Math.min(ans, solve(triangle, i + 1, j + 1, dp));
		return dp[i][j] = ele.get(j) + ans;
	}

//	public int minimumTotal1(List<List<Integer>> triangle) {
//		int n = triangle.size();
//		int m = triangle.get(n - 1).size();
//		int dp[][] = new int[n + 1][m + 1];
//		for (int i = n; i >= 0; i--) {
//			for (int j = m; j >= 0; j--) {
//				if (i == n)
//					dp[i][j] = 0;
//				else if (j > i)
//					continue;
//				else {
//					List<Integer> ele = triangle.get(i);
//					int ans = ele.get(j) + dp[i + 1][j];
//					if (j + 1 < ele.size()) {
//						ans = Math.min(ans, ele.get(j + 1) + dp[i + 1][j + 1]);
//					}
//					dp[i][j] = ans;
//				}
//			}
//		}
//		return dp[0][0];
//	}
//
//	
//	public int solve(List<List<Integer>> triangle, int i, int j, int dp[][]) {
//		if (i == triangle.size()) {
//			return 0;
//		}
//		if (dp[i][j] != -1)
//			return dp[i][j];
//
//		List<Integer> ele = triangle.get(i);
//		int ans = ele.get(j) + solve(triangle, i + 1, j, dp);
//		if (j + 1 < ele.size()) {
//			ans = Math.min(ans, ele.get(j + 1) + solve(triangle, i + 1, j + 1, dp));
//		}
//		return dp[i][j] = ans;
//	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int m = triangle.get(n - 1).size();
		int dp[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		return solve(triangle, 0, 0, dp);
	}

}
