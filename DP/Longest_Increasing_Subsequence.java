package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_Increasing_Subsequence {

	public static int lisRecursion(int arr[], int idx, int lastNo) {
		if (arr.length == idx) {
			return 0;
		}

		int count = 0;
		if (arr[idx] > lastNo) {
			count += (1 + lisRecursion(arr, idx + 1, arr[idx]));
		}

		count = Math.max(count, lisRecursion(arr, idx + 1, lastNo));

		return count;
	}

	public static int lisTabulation(int arr[]) {
		int dp[] = new int[arr.length];
		dp[0] = 1;
		int omax = 1;

		for (int i = 1; i < arr.length; i++) {
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] <= arr[i] && dp[j] > max) {
					max = dp[j];
				}
			}
			dp[i] = max + 1;
			omax = Math.max(omax, dp[i]);
		}
		return omax;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println(lisTabulation(arr));
//		System.out.println(lisRecursion(arr,0,-1));

		scan.close();
	}

}
