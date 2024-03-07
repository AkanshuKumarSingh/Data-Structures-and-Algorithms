package Recursion_and_Backtracking;

public class _54_Nth_catalan_number {

	public static void catalan(int n) {
		int res = 1;
		System.out.print(1 + " ");
		// Iterate till N
		for (int i = 1; i < n; i++) {
			// Calculate the ith Catalan Number
			res = (res * (4 * i - 2)) / (i + 1);
			System.out.print(res + " ");
		}
	}

	public static int findCatalanDp(int n) {
		// Table to store results of subproblems
		int catalan[] = new int[n + 2];

		// Initialize first two values in table
		catalan[0] = 1;
		catalan[1] = 1;

		// Fill entries in catalan[]
		// using recursive formula
		for (int i = 2; i <= n; i++) {
			catalan[i] = 0;
			for (int j = 0; j < i; j++) {
				catalan[i] += catalan[j] * catalan[i - j - 1];
			}
		}

		// Return last entry
		return catalan[n];
	}

	public static int findCatalan(int n) {
		if (n <= 1)
			return 1;

		int res = 0;
		for (int i = 0; i < n; i++) {
			res += (findCatalan(i) * findCatalan(n - i - 1));
		}
		return res;
	}

}
