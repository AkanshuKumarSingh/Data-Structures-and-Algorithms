package DynamicProgramming;

public class _3_Equal_Sum_Partition_Problem {

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

	static int equalPartition(int N, int arr[]){
		int sum = 0;
		for(int no : arr){
			sum += no;
		}
		if(sum%2 == 1) return 0;
		return isSubsetSumRecursion(N, arr, sum/2) ? 1 : 0;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
