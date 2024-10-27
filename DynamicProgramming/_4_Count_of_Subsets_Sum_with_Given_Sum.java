package DynamicProgramming;

import java.util.Arrays;

public class _4_Count_of_Subsets_Sum_with_Given_Sum {

	public static int perfectSumRecursive(int arr[],int n, int sum) { 
        if(n == 0) {
        	if(sum == 0) {
        		return 1;
        	}else {
        		return 0;
        	}
        }

        int ans = 0;
        if(sum - arr[n-1] >= 0){
            ans = perfectSumRecursive(arr, n-1, sum-arr[n-1]) + perfectSumRecursive(arr, n-1, sum);
        }else{
            ans = perfectSumRecursive(arr, n-1, sum);
        }
        return ans;
	} 

	static int t[][];
	static int mod=1000000007;

	public static int perfectSumMemoization(int arr[],int n, int sum) { 
        if(n == 0) { // because suppose we have case of 9, 5, 0, and sum is 14 then we have 2 sets like 9,5 and 9, 5, 0
        	// so when we don't use n == 0 condition we get ans as 1 as we don't process idx of 0 number which we do include
        	// exclude of current idx
        	if(sum == 0) {
        		return t[n][sum]=1;
        	}else {
        		return t[n][sum]=0;
        	}
        }else if(t[n][sum] != -1) return t[n][sum];

        int ans = 0;
        if(sum - arr[n-1] >= 0){
            ans = perfectSumMemoization(arr, n-1, sum-arr[n-1]) + perfectSumMemoization(arr, n-1, sum);
        }else{
            ans = perfectSumMemoization(arr, n-1, sum);
        }
        return t[n][sum]=ans%mod;
	}

	public int perfectSum(int arr[],int n, int sum) { 
		t = new int[n+1][sum+1];
		for(int i = 0 ; i < n+1; i++){
            Arrays.fill(t[i], -1);
        }
        return perfectSumMemoization(arr, n, sum);
	}

	public int perfectSumTabulation(int arr[],int n, int sum) {
		int t[][] = new int[n+1][sum+1];
		for(int i = 0 ; i < n+1; i++) {
			for(int j = 0 ; j <sum+1; j++) {
				if(i == 0) {
					if(j == 0) t[i][j] = 1;
					else t[i][j] = 0;
				}else {
					int ans = 0;
					if(j-arr[i-1] >= 0) {
						ans = (t[i-1][j-arr[i-1]] + t[i-1][j])%mod;
					}else {
						ans = t[i-1][j]%mod;
					}
					t[i][j] = ans;
				}
			}
		}
        return t[n][sum];
	}	
	
	public static void main(String[] args) {
		int arr[] = {0,0,0,0,0,0,0,0,1};
		System.out.println(perfectSumRecursive(arr, arr.length, 1));
		
	}
	
}
