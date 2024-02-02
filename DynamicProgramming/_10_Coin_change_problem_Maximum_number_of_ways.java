package DynamicProgramming;

import java.util.Arrays;

public class _10_Coin_change_problem_Maximum_number_of_ways {

    public long countRecursive(int coins[], int n, int sum) {
        if(sum == 0) return 1;
        else if(n == 0)return 0;

    	if(sum-coins[n-1] >= 0) {
    		return countRecursive(coins, n, sum-coins[n-1]) + countRecursive(coins, n-1, sum);
    	}else {
    		return countRecursive(coins, n-1, sum);
    	}
    }
    
	static long t[][];
	static long countMemoization(int coins[], int n, int sum) {
        if(sum == 0) return 1;
        else if(n == 0)return 0;
			
		if(t[n][sum] != -1) return t[n][sum];	
			
		if (sum - coins[n - 1] >= 0) {
			return t[n][sum] = countMemoization(coins, n, sum-coins[n-1]) + countMemoization(coins, n-1, sum);
		} else {
			return t[n][sum] = countMemoization(coins, n-1, sum);
		}
	}

    
    static long count(int coins[], int n, int sum) { 
        t = new long[n+1][sum+1];
        for(int i = 0 ; i < n+1; i++){
            Arrays.fill(t[i], -1);
        }
        return countMemoization(coins, n, sum);
    } 
    
    static long countTabulation(int coins[], int n, int sum) {
    	long t[][] = new long[n+1][sum+1];
    	for(int i = 0 ; i < n+1; i++) {
    		for(int j = 0; j < sum+1; j++) {
    			if(j == 0) {
    				t[i][j] = 1;
    			}else if(i == 0) {
    				t[i][j] = 0;
    			}else {
    				if(j-coins[i-1] >= 0) {
    					t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
    				}else {
    					t[i][j] = t[i-1][j];
    				}
    			}
    		}
    	}
    	return t[n][sum];
    }
	
	public static void main(String[] args) {
		int coins[] = {1,3,4};
		int total = 6;
		System.out.println(new _10_Coin_change_problem_Maximum_number_of_ways().countRecursive(coins, coins.length, total));

	}

}
