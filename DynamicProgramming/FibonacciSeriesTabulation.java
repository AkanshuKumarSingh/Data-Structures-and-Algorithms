package DynamicProgramming;

public class FibonacciSeriesTabulation {
	// First make Storage - dp[]
	// Second assign meaning to each cell of storage
	// Direction analyze
	public static int fib(int n, int dp[]) {
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i < dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 10;
		int dp[] = new int[n + 1];
		System.out.println(fib(n, dp));
	}

}
