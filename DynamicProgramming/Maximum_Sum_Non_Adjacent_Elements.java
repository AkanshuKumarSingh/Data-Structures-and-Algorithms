package DynamicProgramming;

import java.util.Scanner;

public class Maximum_Sum_Non_Adjacent_Elements {
	
	public static int MSRecursive1(int idx,int arr[],int sum,int li) {
		if(idx >= arr.length) {
			return sum;
		}
		
		if(li == 0) {
			int no1 = MSRecursive1(idx+1,arr,sum+arr[idx],1);
			int no2 = MSRecursive1(idx+1,arr,sum,0);
			
			return Math.max(no1, no2);
		}else {
			int no = MSRecursive1(idx+1,arr,sum,0);
			return no;
		}
	
	}

	public static int MSRecursive(int idx,int arr[],int sum) {
		if(idx >= arr.length) {
			return sum;
		}
		
		return Math.max(MSRecursive(idx+1,arr,sum), MSRecursive(idx+2,arr,sum+arr[idx]));
	}
	
	public static int MSMemoization(int idx,int arr[], int dp[]) {
		if(idx >= arr.length) {
			return dp[idx] = 0;
		}
		
		if(dp[idx] != 0) return dp[idx];
		
		dp[idx] = Math.max(MSMemoization(idx+1,arr,dp),arr[idx]+MSMemoization(idx+2,arr,dp));
		return dp[idx];
	}
	
	public static int MSTabulation(int arr[]) {
		int dp[] = new int[arr.length+2];
		
		for(int i = arr.length+1; i >= 0; i--) {
			if(i == arr.length || i == arr.length+1) {
				dp[i] = 0;
				continue;
			}
			dp[i] = Math.max(dp[i+1], arr[i] + dp[i+2]);
		}
		
		return dp[0];
	}
	
	public static long MSTabulationSir(int arr[]) {
		// by Sir
		long exc = 0;
		long inc = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			long n_exc = Math.max(exc, inc);
			long n_inc = exc + arr[i];
			
			exc = n_exc;
			inc = n_inc;
		}
		
		return Math.max(exc, inc);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println(MSRecursive(0,arr,0));
		System.out.println(MSMemoization(0,arr,new int[n+2]));
		System.out.println(MSTabulation(arr));
		System.out.println(Math.max(MSRecursive1(1,arr,0,0), MSRecursive1(1,arr,arr[0],1)));
	}

}
