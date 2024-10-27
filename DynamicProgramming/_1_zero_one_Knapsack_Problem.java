package DynamicProgramming;

import java.util.Arrays;

public class _1_zero_one_Knapsack_Problem {

	static int knapSackRecursive(int W, int wt[], int val[], int n) {
		if (n == 0 || W == 0)
			return 0;
		if (W - wt[n - 1] >= 0) {
			return Math.max(val[n - 1] + knapSackRecursive(W - wt[n - 1], wt, val, n - 1),
					knapSackRecursive(W, wt, val, n - 1));
		} else {
			return knapSackRecursive(W, wt, val, n - 1);
		}
//		Time Complexity: O(2^n) (Exponential)
//		Space Complexity: O(n) (Call stack depth)
	}

	static int t[][];
	static int knapSackMemoization(int W, int wt[], int val[], int n) {
		if (n == 0 || W == 0)
			return t[n][W] = 0;
			
		if(t[n][W] != -1) return t[n][W];	
			
		if (W - wt[n - 1] >= 0) {
			return t[n][W] = Math.max(val[n - 1] + knapSackMemoization(W - wt[n - 1], wt, val, n - 1),
					knapSackMemoization(W, wt, val, n - 1));
		} else {
			return t[n][W] = knapSackMemoization(W, wt, val, n - 1);
		}
//		Time Complexity: O(n * W) (as each subproblem is solved only once)
//		Space Complexity: O(n * W) (for the table) + O(n) (for the recursion stack). (due to the memoization table and recursion stack)
	}

    
    static int knapSack(int W, int wt[], int val[], int n) { 
        t = new int[n+1][W+1];
        for(int i = 0 ; i < n+1; i++){
            Arrays.fill(t[i], -1);
        }
        return knapSackMemoization(W, wt, val, n);
    } 
    
	static int knapSackTabulation(int W, int wt[], int val[], int n) {
		int t[][] = new int[n+1][W+1];
		for(int i = 0 ; i < n+1; i++){
            Arrays.fill(t[i], -1);
        }
		for(int i = 0 ; i < n+1; i++) {
			for(int j = 0 ; j < W+1; j++) {
				if(i == 0 || j == 0) {
					t[i][j] = 0;
				}else {
					if(j - wt[i-1] >= 0) {
						t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
					}else {
						t[i][j] = t[i-1][j];
					}
				}
			}
		}
		return t[n][W];

//		Time Complexity: O(n * W) (due to the two nested loops iterating over n items and W capacities).
//		Space Complexity: O(n * W) (due to the t[][] table storing the intermediate results).
	}
    
    
    public static void main(String args[]) {
    	
    }

}
