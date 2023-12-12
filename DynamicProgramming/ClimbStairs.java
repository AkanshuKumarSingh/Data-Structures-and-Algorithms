package DynamicProgramming;

public class ClimbStairs {

	public static int csMemoization(int i, int n, int dp[]) {
		if (i == n)
			return dp[i] = 1;

		if (dp[i] != 0)
			return dp[i];

		int count = 0;
		for (int jump = 1; jump <= 3 && jump + i <= n; jump++) {
			count += csMemoization(i + jump, n, dp);
		}
		return dp[i] = count;
	}

	public static int csTabulation(int i, int n, int dp[]) {
		// made	from memoized code
		for (i = n; i >= 0; i--) {
			if (i == n) {
				dp[i] = 1;
				continue;
			}
			int count = 0;
			for (int jump = 1; jump <= 3 && jump + i <= n; jump++) {
				count += dp[i + jump];
			}
			dp[i] = count;
		}
		return dp[0];
	}

	public static int csTabulation1(int i, int n, int dp[]) {
			dp[n] = 1;
			//dp[i] = ways to go to n from i
			for (i = n - 1; i >= 0; i--) {
				if (i + 3 <= n) {
					dp[i] = dp[i + 1] + dp[i + 2] + dp[i + 3];
				} else if (i + 2 <= n) {
					dp[i] = dp[i + 1] + dp[i + 2];
				} else {
					dp[i] = dp[i + 1];
				}
			}
			return dp[0];
	}

	public static void main(String[] args) {
		System.out.println("JMD");
		int n = 7;
		int dp[] = new int[n + 1];
		System.out.println(csMemoization(0, n, dp));
	}

}
