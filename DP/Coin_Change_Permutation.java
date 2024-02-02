package DP;

import java.util.Scanner;

public class Coin_Change_Permutation {

	public static int CCPerRecursive(int coins[], int target) {
		if(target == 0) {
			return 1;
		}
		int cnt = 0;
		for(int i = 0 ; i < coins.length; i++) {
			int coin = coins[i];
			if(target-coin >= 0)
				cnt += (CCPerRecursive(coins,target-coin));
		}
		
		return cnt;
	}
	
	public static int CCPerMemoization(int coins[], int target, int dp[]) {
		if(target == 0) {
			return dp[target] = 1;
		}
		
		if(dp[target] != 0) return dp[target];
		
		int cnt = 0;
		for(int i = 0 ; i < coins.length; i++) {
			if(target-coins[i] >= 0)
				cnt += (CCPerMemoization(coins,target-coins[i],dp));
		}
		return dp[target] = cnt;
	}
	
	public static int CCPerTabulation1(int coins[], int target) {
		int dp[] = new int[target+1];
		dp[0] = 1;
		
//		dp[i] = no of ways to make i target by coins
		
		for(int t = 1 ; t <= target; t++) {
			int count = 0;
			for(int i = 0 ; i < coins.length; i++) {
				int coin = coins[i];
				if(t-coin >= 0) {
					count += (dp[t-coin]);
				}
			}
			dp[t] = count;
		}
		return dp[target];
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int coins[] = new int[n];
		for(int i = 0; i < n ; i++) {
			coins[i] = scan.nextInt();
		}
		int target = scan.nextInt();
		System.out.println(CCPerRecursive(coins,target));
		System.out.println(CCPerMemoization(coins,target,new int[target+1]));
		System.out.println(CCPerTabulation1(coins,target));
	}

}
