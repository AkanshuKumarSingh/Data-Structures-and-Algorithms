package DP;

import java.util.Scanner;

public class Unbounded_KnapSack {

	private static int UkRecursive(int[] values, int[] weights, int capacity, int i) {
		if(capacity == 0) {
			return 0;
		}else if(i == values.length) {
			return 0;
		}
		int val = Integer.MIN_VALUE;
		if(capacity - weights[i] >= 0) {
			val = values[i] + UkRecursive(values,weights,capacity - weights[i],i);
		}
		val = Math.max(val,UkRecursive(values,weights,capacity,i+1));
		
		return val;
	}
	
	private static int UkMemoization(int[] values, int[] weights, int capacity, int i,int dp[][]) {
		if(capacity == 0) {
			return dp[i][capacity] = 0;
		}else if(i == values.length) {
			return dp[i][capacity] = 0;
		}
		
		if(dp[i][capacity] != 0) {
			return dp[i][capacity];
		}
		
		int val = Integer.MIN_VALUE;
		if(capacity - weights[i] >= 0) {
			val = values[i] + UkMemoization(values,weights,capacity - weights[i],i,dp);
		}
		val = Math.max(val,UkMemoization(values,weights,capacity,i+1,dp));
		
		return dp[i][capacity] = val;
	}
	
	private static int UkTabulation(int[] values, int[] weights, int capacity) {
		int dp[] = new int[capacity+1];
		
		for(int i = 0 ; i < values.length; i++) {
			int wt = weights[i];
			int val = values[i];
			
			for(int c = wt; c <= capacity; c++) {
				int v1 = dp[c-wt] + val;
				int v2 = dp[c];
				dp[c] = Math.max(v1, v2);
			}
			
		}
		return dp[capacity];
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
		System.out.println(UkRecursive(values, weights, capacity, 0));
		System.out.println(UkMemoization(values, weights, capacity, 0, new int[n + 1][capacity + 1]));
		System.out.println(UkTabulation(values, weights, capacity));
	}

}
