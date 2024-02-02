package DynamicProgramming;

import java.util.Arrays;

public class _11_Coin_change_problem_Minimum_number_of_coins {

	public int findMinCoinsRecursive(int coins[], int n, int val) {
	    if(val == 0) return 0;
	    else if(n == 0) return Integer.MAX_VALUE-1;
	    
	    if(val - coins[n-1] >= 0){
	        return Math.min(1 + findMinCoinsRecursive(coins, n, val-coins[n-1]), findMinCoinsRecursive(coins, n-1, val));
	    }else{
	        return findMinCoinsRecursive(coins, n-1, val);
	    }
	} 

	public int minCoinsRecursive(int coins[], int n, int val) {
	    int ans = findMinCoinsRecursive(coins, n, val);
	    return ans == Integer.MAX_VALUE-1 ? -1 : ans;
	}
	
	static int t[][];
	public int findMinCoinsMemoization(int coins[], int n, int val) {
	    if(val == 0) return t[n][val]=0;
	    else if(n == 0) return t[n][val]=Integer.MAX_VALUE-1;
	    
	    if(t[n][val]!=-1) return t[n][val];
	    
	    if(val - coins[n-1] >= 0){
	        return t[n][val]=Math.min(1 + findMinCoinsMemoization(coins, n, val-coins[n-1]), findMinCoinsMemoization(coins, n-1, val));
	    }else{
	        return t[n][val]=findMinCoinsMemoization(coins, n-1, val);
	    }
	} 

	public int minCoinsMemoization(int coins[], int n, int val) {
        t = new int[n+1][val+1];
        for(int i = 0 ; i < n+1; i++){
            Arrays.fill(t[i], -1);
        }
	    int ans = findMinCoinsMemoization(coins, n, val);
	    return ans == Integer.MAX_VALUE-1 ? -1 : ans;
	}

	public int findMinCoinsTabulation(int coins[], int n, int val) {
		int t[][] = new int[n+1][val+1];
		for(int i = 0 ; i < n+1; i++) {
			for(int j = 0 ; j < val+1; j++) {
				if(j == 0) {
					t[i][j] = 0;
				}else if(i == 0) {
					t[i][j] = Integer.MAX_VALUE-1;
				}else {
					if(j-coins[i-1] >= 0) {
						t[i][j] = Math.min(1+t[i][j-coins[i-1]], t[i-1][j]); 
					}else {
						t[i][j] = t[i-1][j];
					}
				}
			}
		}
	    return t[n][val] == Integer.MAX_VALUE-1 ? -1 : t[n][val];
	} 

	
	public static void main(String args[]) {
		int coins[] = {1,3,4};
		int total = 6;
		System.out.println(new _11_Coin_change_problem_Minimum_number_of_coins().findMinCoinsRecursive(coins, coins.length, total));
	}
	
}
