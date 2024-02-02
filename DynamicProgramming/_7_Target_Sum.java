package DynamicProgramming;

public class _7_Target_Sum {

	static int mod=1000000007;
	public static int perfectSumTabulation(int arr[],int n, int sum) {
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
	
    static int findTargetSumWays( int N, int[] A ,int target) {
    	int sum = 0;
    	for(int no : A) {
        	sum += no;
        }
    	if((sum+target)%2 == 1) return 0;
    	int s1 = (sum+target)/2;
    	System.out.println(sum + " " + s1);
    	return perfectSumTabulation(A, N, s1);
    	
    }
	
}
