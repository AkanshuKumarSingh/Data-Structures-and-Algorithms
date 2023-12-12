package DynamicProgramming;

import java.util.Scanner;

public class Coin_Change_Combination {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int coins[] = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = scan.nextInt();
		}
		int target = scan.nextInt();
		System.out.println(CCComRecursive(coins, target, 0));
		System.out.println(CCComMemoization(coins,target,0,new int[n+1][target+1]));
		System.out.println(CCComMemoization1(coins,target,0,new int[n+1][target+1]));
		System.out.println(CCComTabulation1(coins, target));
		System.out.println(CCComTabulation2(coins, target));

	}

	public static int CCComTabulation1(int[] coins, int target) {
		int dp[] = new int[target + 1];
		dp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			int coin = coins[i];
			for (int t = coin; t <= target; t++) {
				dp[t] += dp[t - coin];
			}
		}
		return dp[target];
	}

	private static int CCComTabulation2(int[] coins, int target) {
		int dp[][] = new int[coins.length + 1][target + 1];
		int n = coins.length + 1;
		int m = target + 1;
		for(int c = 0;c < m; c++) {
			for(int r = 0; r < n; r++) {
				if(c == 0) {
					dp[r][c] = 1;
					continue;
				}
				int cnt = 0;
				for (int i = r; i < coins.length; i++) {
					if (c - coins[i] >= 0) {
						cnt += (dp[i][c - coins[i]]);
					}
				}
				dp[r][c] = cnt;
			}
		}
		return dp[0][target];
	}

	private static int CCComRecursive(int[] coins, int target, int li) {
		if (target == 0) {
			return 1;
		}

		int cnt = 0;
		for (int i = li; i < coins.length; i++) {
			if (target - coins[i] >= 0) {
				cnt += (CCComRecursive(coins, target - coins[i], i));
			}
		}
		return cnt;
	}

	public static int CCComMemoization(int coins[], int target,int li, int dp[][]) {
		if(target == 0) {
			return dp[li][target] = 1;
		}
		
		if(dp[li][target] != 0) {
			return dp[li][target];
		}
		
		int cnt = 0;
		for (int i = li; i < coins.length; i++) {
			if (target - coins[i] >= 0) {
				cnt += (CCComMemoization(coins, target - coins[i], i,dp));
			}
		}
		return dp[li][target]=cnt;
	}

	public static int CCComMemoization1(int coins[], int target, int li, int dp[][]) {
		if (target == 0) {
			return dp[li][target] = 1;
		}else if(li == coins.length) {
			return dp[li][target] = 0;
		}

		if (dp[li][target] != 0) {
			return dp[li][target];
		}

		int cnt = 0;
		if (target - coins[li] >= 0) {
			cnt += (CCComMemoization1(coins, target - coins[li], li, dp));
		}
		cnt += (CCComMemoization1(coins, target, li+1, dp));

		return dp[li][target] = cnt;
	}
	
}
