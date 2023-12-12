package DynamicProgramming;

public class FibonacciSeriesMemoization {

	public static int fib(int n,int dp[]) {
		if(n == 0 || n == 1) {
			dp[n] = n;
			return n;
		}
		
		if(dp[n] != 0) {
			return dp[n];
		}
		
		int fibm1 = fib(n-1,dp);
		int fibm2 = fib(n-2,dp);
		
		dp[n] = fibm1+fibm2;
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 10;
		int dp[] = new int[n+1];
		System.out.println(fib(n,dp));
	}

}
