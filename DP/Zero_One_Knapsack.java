package DP;

import java.util.Scanner;

public class Zero_One_Knapsack {

	public static int zokRecursive(int[] values, int[] weights, int capacity, int st) {
		if (capacity == 0) {
			return 0;
		}
		if (st == values.length) {
			return 0;
		}

		int value = 0;
		for (int i = st; i < weights.length; i++) {
			if (capacity - weights[i] >= 0) {
				value = Math.max(value, (values[i] + zokRecursive(values, weights, capacity - weights[i], i + 1)));
			}
		}
		return value;
	}

	public static int zokMemoization(int[] values, int[] weights, int capacity, int st, int dp[][]) {
		if (capacity == 0) {
			return dp[st][capacity] = 0;
		}
		if (st == values.length) {
			return dp[st][capacity] = 0;
		}

		if (dp[st][capacity] != 0)
			return dp[st][capacity];

		int value = Integer.MIN_VALUE;
		if (capacity - weights[st] >= 0) {
			value = (values[st] + zokMemoization(values, weights, capacity - weights[st], st + 1, dp));
		}

		value = Math.max(value, zokMemoization(values, weights, capacity, st + 1, dp));
		
		return dp[st][capacity] = value;
	}

	public static int zokTabulation(int[] values, int[] weights, int capacity) {

		int n = weights.length + 1;
		int m = capacity + 1;
		int dp[][] = new int[n][m];

		for (int i = 1; i < n; i++) {
			int wt = weights[i - 1];
			int val = values[i - 1];
			for (int c = 1; c < m; c++) {
				if (c < wt) {
					dp[i][c] = dp[i - 1][c];
				} else {
					dp[i][c] = Math.max(dp[i - 1][c - wt] + val, dp[i - 1][c]);
				}
			}
		}
		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int values[] = new int[n];
		int weights[] = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = scan.nextInt();
		}
		for (int i = 0; i < n; i++) {
			weights[i] = scan.nextInt();
		}
		int capacity = scan.nextInt();
		System.out.println(zokRecursive(values, weights, capacity, 0));
		System.out.println(zokMemoization(values, weights, capacity, 0, new int[n + 1][capacity + 1]));
		System.out.println(zokTabulation(values, weights, capacity));

	}

}
