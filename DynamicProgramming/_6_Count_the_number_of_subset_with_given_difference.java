package DynamicProgramming;

public class _6_Count_the_number_of_subset_with_given_difference {

	static int mod=1000000007;
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
	
    public int countPartitions(int n, int d, int arr[]){
        int sum = 0;
        for(int no : arr) {
        	sum += no;
        }
    	if((sum+d)%2 == 1) return 0;
    	int s1 = (sum+d)/2;
    	System.out.println(sum + " " + s1);
    	return perfectSumTabulation(arr, n, s1);
    }
	
    public static void main(String args[]) {
    	int arr[] = {2, 40, 6, 6, 43, 44, 10, 32, 12, 12, 26, 31, 48, 14, 38, 42, 25};
    	System.out.println(new _6_Count_the_number_of_subset_with_given_difference().countPartitions(arr.length, 2, arr));
    }
    
}
