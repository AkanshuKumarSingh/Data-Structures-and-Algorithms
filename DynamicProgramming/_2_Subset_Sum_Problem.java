 package DynamicProgramming;

public class _2_Subset_Sum_Problem {

	static Boolean isSubsetSumRecursion(int N, int arr[], int sum){
        if(sum == 0) return true;
        else if(N == 0) return false;
        
		boolean ans = false;
		if(sum - arr[N-1] >= 0) {
			ans = isSubsetSumRecursion(N-1, arr, sum-arr[N-1]) || isSubsetSumRecursion(N-1, arr, sum);
		}else {
			ans = isSubsetSumRecursion(N-1, arr, sum);			
		}
		
		return ans;
    }
	
	static boolean t[][];
	static Boolean isSubsetSumMemoization(int N, int arr[], int sum){
        if(sum == 0) return t[N][sum]=true;
        else if(N == 0) return t[N][sum]=false;
        else if(t[N][sum]) return t[N][sum];
        
		boolean ans = false;
		if(sum - arr[N-1] >= 0) {
			ans = isSubsetSumRecursion(N-1, arr, sum-arr[N-1]) || isSubsetSumRecursion(N-1, arr, sum);
		}else {
			ans = isSubsetSumRecursion(N-1, arr, sum);			
		}

		return t[N][sum]=ans;
    }
	
    static Boolean isSubsetSum(int N, int arr[], int sum){
    	t = new boolean[N+1][sum+1];
    	return isSubsetSumMemoization(N, arr, sum);
    }

	static Boolean isSubsetSumTabulation(int N, int arr[], int sum){
		boolean t[][] = new boolean[N+1][sum+1];
		
		for(int i = 0; i < N+1; i++) {
			for(int j = 0; j < sum+1; j++) {
				if(j == 0) {
					t[i][j] = true;
				}else if(i == 0) {
					t[i][j] = false;
				}else {
					boolean ans = false;
					if(j-arr[i-1] >= 0) {
						ans = t[i-1][j-arr[i-1]] || t[i-1][j];
					}else {
						ans = t[i-1][j];
					}
					t[i][j] = ans;
				}
			}
		}
		
		return t[N][sum];
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
