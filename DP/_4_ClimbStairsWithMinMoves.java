package DP;

import java.util.Scanner;

public class _4_ClimbStairsWithMinMoves {

	public static int csRecursive(int i, int n, int arr[]) {
		if (i == n) {
			return 0;
		}

		int minjump = Integer.MAX_VALUE - 1;
		for (int jump = 1; jump <= arr[i] && jump + i <= n; jump++) {
			minjump = Math.min(minjump, 1 + csRecursive(jump + i, n, arr));
		}

		return minjump;
	}

	public static int csMemozized(int i, int n, int arr[], int dp[]) {
		if (i == n) {
			return dp[i] = 0;
		}

		if (dp[i] != 0)
			return dp[i];

		int min = Integer.MAX_VALUE - 1;
		for (int jump = 1; jump <= arr[i] && jump + i <= n; jump++) {
			min = Math.min(min, csRecursive(jump + i, n, arr));
		}

		dp[i] = min + 1;

		return min + 1;
	}

	static String path[] = new String[11];

	public static int csTabulation(int i, int n, int arr[], int dp[]) {

		for (i = n; i >= 0; i--) {
			if (i == n) {
				dp[i] = 0;
				path[i] = "";
				continue;
			}

			int min = Integer.MAX_VALUE - 1;
			for (int jump = 1; jump <= arr[i] && jump + i <= n; jump++) {
				min = Math.min(min, dp[i + jump]); // only min moves of path
			}
			dp[i] = min + 1;
		}
		return dp[0];
	}

	public static int csTabulationWithPathPrint(int i, int n, int arr[], int dp[]) {

		for (i = n; i >= 0; i--) {
			if (i == n) {
				dp[i] = 0;
				path[i] = "";
				continue;
			}

			int min = Integer.MAX_VALUE - 1;
			for (int jump = 1; jump <= arr[i] && jump + i <= n; jump++) {
				if (min > dp[i + jump]) {
					min = dp[i + jump];// min moves with path
					path[i] = jump + path[i + jump];
				}
			}
			dp[i] = min + 1;
		}
		System.out.println(path[0]);
		return dp[0];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int dp[] = new int[n + 1];
		System.out.println(csRecursive(0, n, arr));
		System.out.println(csMemozized(0, n, arr, new int[n + 1]));
		System.out.println(csTabulation(0, n, arr, dp));

	}

}
