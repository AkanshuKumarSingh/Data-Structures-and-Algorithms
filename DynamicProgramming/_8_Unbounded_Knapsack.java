package DynamicProgramming;

import java.util.Arrays;

public class _8_Unbounded_Knapsack {

	static int knapSackRecursive(int N, int W, int val[], int wt[]) {
		if (N == 0 || W == 0)
			return 0;
		if (W - wt[N - 1] >= 0) {
			return Math.max(val[N - 1] + knapSackRecursive(N, W - wt[N - 1], val, wt),
					knapSackRecursive(N - 1, W, val, wt));
		} else {
			return knapSackRecursive(N - 1, W, val, wt);
		}

	}

	static int t[][];

	static int knapSackMemoization(int N, int W, int val[], int wt[]) {
		if (N == 0 || W == 0)
			return t[N][W] = 0;

		if (t[N][W] != -1)
			return t[N][W];

		if (W - wt[N - 1] >= 0) {
			return t[N][W] = Math.max(val[N - 1] + knapSackMemoization(N, W - wt[N - 1], val, wt),
					knapSackMemoization(N - 1, W, val, wt));
		} else {
			return t[N][W] = knapSackMemoization(N - 1, W, val, wt);
		}
	}

	static int knapSack(int N, int W, int val[], int wt[]) {
		t = new int[N + 1][W + 1];
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(t[i], -1);
		}
		return knapSackMemoization(N, W, val, wt);
	}

	static int knapSackTabulation(int N, int W, int val[], int wt[]) {
		int t[][] = new int[N + 1][W + 1];
		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(t[i], -1);
		}
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				} else {
					if (j - wt[i - 1] >= 0) {
						t[i][j] = Math.max(val[i - 1] + t[i][j - wt[i - 1]], t[i - 1][j]);
					} else {
						t[i][j] = t[i - 1][j];
					}
				}
			}
		}
		return t[N][W];
	}

	public static void main(String args[]) {
		int N = 2;
		int W = 3;
		int val[] = { 1, 1 };
		int wt[] = { 2, 1 };
		System.out.println(knapSackRecursive(N, W, val, wt));
	}

}
