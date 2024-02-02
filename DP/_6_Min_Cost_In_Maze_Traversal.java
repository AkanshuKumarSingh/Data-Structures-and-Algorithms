package DP;

import java.util.Scanner;

public class _6_Min_Cost_In_Maze_Traversal {

	public static int mcRecursive(int mat[][], int r, int c) {
		if (r == mat.length - 1 && c == mat[0].length - 1) {
			return mat[r][c];
		}

		int cost = Integer.MAX_VALUE;
		if (r + 1 < mat.length) {
			cost = Math.min(cost, mcRecursive(mat, r + 1, c));
		}
		if (c + 1 < mat[0].length) {
			cost = Math.min(cost, mcRecursive(mat, r, c + 1));
		}

		return cost + mat[r][c];

	}

	public static int mcMemoization(int mat[][], int r, int c, int dp[][]) {
		if (r == mat.length - 1 && c == mat[0].length - 1) {
			return dp[r][c] = mat[r][c];
		}

		if (dp[r][c] != 0)
			return dp[r][c];

		int cost = Integer.MAX_VALUE;

		if (c + 1 < mat[0].length) {
			cost = Math.min(cost, mcMemoization(mat, r, c + 1, dp));
		}

		if (r + 1 < mat.length) {
			cost = Math.min(cost, mcMemoization(mat, r + 1, c, dp));
		}

		dp[r][c] = cost + mat[r][c];

		return dp[r][c];
	}

	public static int mcTabulation(int mat[][], int r, int c) {

		// Done by thinking

		int n = mat.length;
		int m = mat[0].length;
		int dp[][] = new int[n][m];

		for (r = n - 1; r >= 0; r--) {
			for (c = m - 1; c >= 0; c--) {
				if (r == n - 1 && c == m - 1) {
					dp[r][c] = mat[r][c];
				} else if (r == n - 1) {
					dp[r][c] = mat[r][c] + dp[r][c + 1];
				} else if (c == m - 1) {
					dp[r][c] = mat[r][c] + dp[r + 1][c];
				} else {
					dp[r][c] = mat[r][c] + Math.min(dp[r + 1][c], dp[r][c + 1]);
				}
			}
		}
		return dp[0][0];
	}

	public static int mcTabulation1(int mat[][], int r, int c) {

		// Done by thinking changing memozized code

		int n = mat.length;
		int m = mat[0].length;
		int dp[][] = new int[n][m];

		for(c = m-1; c >= 0; c--) {
			for(r = n-1; r >= 0; r--) {
				if(r == n-1 && c == m-1) {
					dp[r][c] = mat[r][c];
					continue;
				}
				
				int cost = Integer.MAX_VALUE;
				if(c+1 < m) {
					cost = Math.min(cost, dp[r][c+1]);
				}
				if(r+1 < n) {
					cost = Math.min(cost, dp[r+1][c]);
				}
				
				dp[r][c] = mat[r][c] + cost;
			}
		}
		
		return dp[0][0];
	}

		
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int mat[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat[i][j] = scan.nextInt();
			}
		}
		int dp[][] = new int[n][m];
		System.out.println(mcRecursive(mat, 0, 0));
		System.out.println(mcMemoization(mat, 0, 0, dp));
		System.out.println(mcTabulation1(mat, 0, 0));

	}

}