package DynamicProgramming;

import java.util.Arrays;

public class _23_Matrix_Chain_Multiplication {
	
	static int mcmRecursive(int arr[], int i, int j) {
		if(i >= j) return 0;		
		int ans = Integer.MAX_VALUE;
		for(int k = i ; k < j; k++) {
			int count = mcmRecursive(arr, i, k) + mcmRecursive(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
			ans = Math.min(ans, count);
		}
		
		return ans;
	}
	
    static int t[][];
	static int mcmMemoization(int arr[], int i, int j) {
		if(i >= j) return 0;
		
		if(t[i][j] != -1) return t[i][j];
		
		int ans = Integer.MAX_VALUE;
		for(int k = i ; k < j; k++) {
			int count = mcmMemoization(arr, i, k) + mcmMemoization(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
			ans = Math.min(ans, count);
		}
		
		return t[i][j]=ans;
	}

    static int matrixMultiplication(int n, int arr[]){
        t = new int[n][n];
        for(int i = 0 ; i < n; i++) {
        	Arrays.fill(t[i], -1);
        }
    	return mcmMemoization(arr, 1, n-1);
    }
	
}
