package DP;

import java.util.Scanner;

public class Target_Sum_Subsets {

	public static boolean tssRecursive(int arr[], int idx, int target) {
		if (target == 0) {
			return true;
		}
		if (idx == arr.length) {
			return false;
		}

		boolean res = false;
		if (target - arr[idx] >= 0) {
			res = tssRecursive(arr, idx + 1, target - arr[idx]);
		}

		res = res || tssRecursive(arr, idx + 1, target);
		return res;
	}

	public static boolean tssMemoization(int arr[], int idx, int target, boolean dp[][]) {
		if (target == 0) {
			return dp[idx][target] = true;
		}
		if (idx == arr.length) {
			return dp[idx][target] = false;
		}

		if (dp[idx][target] == true) {
			return dp[idx][target];
		}

		boolean res = false;
		if (target - arr[idx] >= 0) {
			res = tssMemoization(arr, idx + 1, target - arr[idx], dp);
		}

		res = res || tssMemoization(arr, idx + 1, target, dp);
		return dp[idx][target] = res;
	}

	public static boolean tssTabulation(int arr[], int target) {
		boolean dp[][] = new boolean[arr.length + 1][target + 1];

		for (int i = 0; i <= arr.length; i++) {
			int val = (i > 0) ? arr[i - 1] : 0;
			for (int t = 0; t <= target; t++) {
				if (i == 0 && t == 0) {
					dp[i][t] = true;
				} else if (t == 0) {
					dp[i][t] = true;
				} else if (i == 0) {
					dp[i][t] = false;
				} else {
					if (t - val >= 0) {
						dp[i][t] = dp[i - 1][t - val] || dp[i - 1][t];
					} else {
						dp[i][t] = dp[i - 1][t];
					}
				}
			}
		}

		return dp[arr.length][target];
	}

	public static int tssMemoization_noOfWays(int arr[], int idx, int target, int dp[][], String ans) {
		if (target == 0) {
///			System.out.println(ans);
			return dp[idx][target] = 1;
		}
		if (idx == arr.length) {
			return dp[idx][target] = 0;
		}

		if (dp[idx][target] != 0) {
			return dp[idx][target];
		}

		int res = 0;
		if (target - arr[idx] >= 0) {
			res = tssMemoization_noOfWays(arr, idx + 1, target - arr[idx], dp, ans + arr[idx] + " ");
		}

		res += tssMemoization_noOfWays(arr, idx + 1, target, dp, ans);
		return dp[idx][target] = res;
	}

	public static int tssTabulation_noOfWays(int arr[], int target) {
		int dp[][] = new int[arr.length + 1][target + 1];
		
		for (int i = 0; i < dp.length; i++) {
			int val = (i > 0) ? arr[i-1] : 0;
			for(int t = 0 ; t <= target; t++) {
				if(i == 0 && t == 0) {
					dp[i][t] = 1;
				}else if(i == 0) {
					dp[i][t] = 0;
				}else if(t == 0) {
					dp[i][t] = 1;
				}else {
					int cnt = 0;
					if(t-val >= 0) {
						cnt += (dp[i-1][t-val] + dp[i-1][val]);
					}else {
						cnt += dp[i-1][val];
					}
					dp[i][t] = cnt;
				}
			}
		}
		return dp[arr.length][target];
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int target = scan.nextInt();

		System.out.println(tssRecursive(arr, 0, target));
		boolean dp[][] = new boolean[n + 1][target + 1];
		System.out.println(tssMemoization(arr, 0, target, dp));
		System.out.println(tssTabulation(arr, target));
		int dp1[][] = new int[n + 1][target + 1];
		System.out.println(tssMemoization_noOfWays(arr, 0, target, dp1, ""));
		System.out.println(tssTabulation_noOfWays(arr, target));

	}

}
