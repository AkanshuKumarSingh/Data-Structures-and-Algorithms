package DP;

import java.util.Scanner;

public class _7_Goldmine {

	public static int rdir[] = { -1, 0, 1 };
	public static int cdir[] = { 1, 1, 1 };

	public static int gmRecursive(int mine[][], int sr, int sc) {
		if(sc == mine[0].length-1) {
			return mine[sr][sc];
		}
		// top right

		// next right

		// bottom right
		
		int maxGold = 0;
		for(int d = 0; d < 3; d++) {
			int rr = sr + rdir[d];
			int cc = sc + cdir[d];
			if(rr >= 0 && rr < mine.length && cc < mine.length) {
				maxGold = Math.max(maxGold, gmRecursive(mine,rr,cc));
			}
		}
		
		return maxGold + mine[sr][sc];

	}

	public static int gmMemoization(int mine[][], int sr, int sc, int dp[][]) {
		if(sc == mine[0].length-1) {
			return dp[sr][sc] = mine[sr][sc];
		}
		// top right

		// next right

		// bottom right
		
		if(dp[sr][sc] != 0) return dp[sr][sc];
		
		int maxGold = 0;
		
		for(int d = 0; d < 3; d++) {
			int rr = sr + rdir[d];
			int cc = sc + cdir[d];
			if(rr >= 0 && rr < mine.length ) {
				maxGold = Math.max(maxGold, gmMemoization(mine,rr,cc,dp));
			}
		}
		
		return dp[sr][sc] =  maxGold + mine[sr][sc];

	}

	
	public static int gmTabulation1(int mine[][]) {
		
		// made by changing memoized code
		int n = mine.length;
		int m = mine[0].length;
		int dp[][] = new int[n][m];
		
		for(int c = m-1; c >= 0; c--) {
			for(int r = n-1; r >= 0; r--) {
				if(c == m-1) {
					dp[r][c] = mine[r][c];
					continue;
				}
				int maxGold = Integer.MIN_VALUE;
				for(int d = 0; d < 3; d++) {
					int rr = r + rdir[d];
					int cc = c + cdir[d];
					if(rr >= 0 && rr < mine.length ) {
						maxGold = Math.max(maxGold, dp[rr][cc]);
					}
				}		
				dp[r][c] = maxGold + mine[r][c]; 
			}
		}
		
		int maxGold = 0;
		for(int r = n-1 ; r >= 0 ; r--) {
			maxGold = Math.max(maxGold, dp[r][0]);
		}
		return maxGold;
	}
	
	public static int gmTabulation2(int mine[][]) {
		
		// made by thinking over memoized code
		int n = mine.length;
		int m = mine[0].length;
		int dp[][] = new int[n][m];
		
		for(int c = m-1; c >= 0; c--) {
			for(int r = 0; r < n; r++) {
				if(c == m-1) {
					dp[r][c] = mine[r][c];
				}else if(r == 0) {
					dp[r][c] = mine[r][c] + Math.max(dp[r][c+1], dp[r+1][c+1]);
				}else if(r == n-1) {
					dp[r][c] = mine[r][c] + Math.max(dp[r][c+1], dp[r-1][c+1]);
				}else {
					dp[r][c] = mine[r][c] + Math.max(dp[r][c+1], Math.max(dp[r-1][c+1], dp[r+1][c+1]));
				}
			}
		}
		
//		for(int i = 0 ; i < n; i++) {
//			for(int j = 0 ; j < m ; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		int maxGold = 0;
		for(int r = n-1 ; r >= 0 ; r--) {
			maxGold = Math.max(maxGold, dp[r][0]);
		}
		return maxGold;
	}
	
	public static void helper(int mine[][], int n, int m) {

		int maxGold = 0;
		int dp[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			maxGold = Math.max(maxGold, gmMemoization(mine, i, 0,dp));
		}
		System.out.println(maxGold);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = n;
		int mat[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat[i][j] = scan.nextInt();
			}
		}
		helper(mat, n,m);
		System.out.println(gmTabulation1(mat));
		System.out.println(gmTabulation2(mat));
	}

}
