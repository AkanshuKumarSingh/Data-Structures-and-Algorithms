package DP;

import java.util.Scanner;

public class Tiling_With_2_1_Tiles {

	public static int tilesRecursive(int n) {
		if (n == 0)
			return 1;
		int cnt = 0;
		cnt += tilesRecursive(n - 1);
		if (n - 2 >= 0) {
			cnt += tilesRecursive(n - 2);
		}
		return cnt;
	}

	public static int tilesMemoization(int n, int dp[]) {
		if (n == 0)
			return dp[n] = 1;

		if (dp[n] != 0)
			return dp[n];

		int cnt = 0;
		cnt += tilesMemoization(n - 1, dp);
		if (n - 2 >= 0) {
			cnt += tilesMemoization(n - 2, dp);
		}
		return dp[n] = cnt;
	}

	public static int tilesTabulation(int n) {
		// Sir : fibonacci after analyzing
		int a = 1;
		int b = 2;

		for (int i = 1; i < n; i++) {
			int c = a+b;
			a = b;
			b = c;
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(tilesRecursive(n));
		System.out.println(tilesMemoization(n, new int[n + 1]));
		System.out.println(tilesTabulation(n));
	}

}
