package DP;

import java.util.Scanner;

public class Friends_Pairing {

	public static int fp(int n, int dp[]) {
		if (n == 0)
			return dp[n] = 1;
		else if (dp[n] != 0)
			return dp[n];
		int cnt = fp(n - 1, dp);
		if (n - 2 >= 0) {
			cnt += (n - 1) * fp(n - 2, dp);
		}
		return dp[n] = cnt;
	}

	public static int fpTabulation(int n) {
		if (n == 1)
			return 1;
		int a = 1;
		int b = 2;

		for (int i = 3; i <= n; i++) {
			// f(n) = f(n-1) + (n-1)*f(n-2)
			int c = b + (i - 1) * a;

			a = b;
			b = c;
		}

		return b;

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(fpTabulation(n));
	}

}
