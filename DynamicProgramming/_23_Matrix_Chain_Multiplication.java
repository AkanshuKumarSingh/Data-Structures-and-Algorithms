package DynamicProgramming;

import java.util.Arrays;

public class _23_Matrix_Chain_Multiplication {

	static int matrixMultiplication1(int n, int arr[]) {
		int dp[][] = new int[n][n];
		for (int i = n - 1; i >= 1; i--) {
			for (int j = i + 1; j < n; j++) {
				if (i == j)
					dp[i][j] = 0;
				else {
					int ans = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int steps = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
						ans = Math.min(ans, steps);
					}
					dp[i][j] = ans;
				}
			}
		}
		return dp[1][n - 1];
	}

	static int mcmRecursive(int arr[], int i, int j) {
		if (i >= j)
			return 0;
		int ans = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int steps = mcmRecursive(arr, i, k) + mcmRecursive(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			ans = Math.min(ans, steps);
		}

		return ans;
		
//		Time Complexity: The time complexity of this recursive solution is O(2^N), where N is the number of matrices.
//		Space Complexity: The space complexity is O(N) due to the recursion stack.
		
//		the recurrence relation is approximately:
//		T(N)= k=1
//				∑ (T(k)+T(N−k))+O(N)
//			  N−1
//	    The exact time complexity for this recursive process is roughly: O(4^N) but we usually take it as O(2^n)


	}

	static int t[][];

	static int mcmMemoization(int arr[], int i, int j) {
		if (i >= j)
			return 0;

		if (t[i][j] != -1)
			return t[i][j];

		int ans = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int steps = mcmMemoization(arr, i, k) + mcmMemoization(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			ans = Math.min(ans, steps);
		}

		return t[i][j] = ans;
	}

	static int matrixMultiplication(int n, int arr[]) {
		t = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(t[i], -1);
		}
		return mcmMemoization(arr, 1, n - 1);
	}

}
