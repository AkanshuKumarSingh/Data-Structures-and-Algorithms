package DynamicProgramming;

import java.util.Arrays;

public class _25_Evaluate_Expression_to_True_Boolean_Parenthesization {

	static int booleanParenthesizationRecursive(String str, int i, int j, boolean isTrue) {
		if (i > j)
			return 0;

		if (i == j) {
			if (isTrue == true) {
				if (str.charAt(i) == 'T') {
					return 1;
				} else {
					return 0;
				}
			} else {
				if (str.charAt(i) == 'T') {
					return 0;
				} else {
					return 1;
				}
			}
		}

		int ans = 0;
		for (int k = i + 1; k < j; k=k+2) {
			int leftTrue = booleanParenthesizationRecursive(str, i, k - 1, true);
			int leftFalse = booleanParenthesizationRecursive(str, i, k - 1, false);
			int rightTrue = booleanParenthesizationRecursive(str, k + 1, j, true);
			int rightFalse = booleanParenthesizationRecursive(str, k + 1, j, false);

			char operation = str.charAt(k);
			if (operation == '|') {
				if (isTrue) {
					ans += (leftFalse * rightTrue + leftTrue * rightFalse + leftTrue * rightTrue);
				} else {
					ans += (leftFalse * rightFalse);
				}
			} else if (operation == '&') {
				if (isTrue) {
					ans += (leftTrue * rightTrue);
				} else {
					ans += (leftFalse * rightTrue + leftTrue * rightFalse + leftFalse * rightFalse);
				}
			} else if (operation == '^') {
				if (isTrue) {
					ans += (leftFalse * rightTrue + leftTrue * rightFalse);
				} else {
					ans += (leftFalse * rightFalse + leftTrue * rightTrue);
				}
			}

		}

		return ans;
	}

	static int t[][][];
	static int booleanParenthesizationMemoization(String str, int i, int j, boolean isTrue) {
		if (i > j)
			return 0;

		if (i == j) {
			if (isTrue == true) {
				if (str.charAt(i) == 'T') {
					return 1;
				} else {
					return 0;
				}
			} else {
				if (str.charAt(i) == 'T') {
					return 0;
				} else {
					return 1;
				}
			}
		}


		if(t[i][j][isTrue ? 1: 0] != -1) return t[i][j][isTrue ? 1: 0];

		int ans = 0;
		for (int k = i + 1; k < j; k=k+2) {
			int leftTrue = booleanParenthesizationMemoization(str, i, k - 1, true);
			int leftFalse = booleanParenthesizationMemoization(str, i, k - 1, false);
			int rightTrue = booleanParenthesizationMemoization(str, k + 1, j, true);
			int rightFalse = booleanParenthesizationMemoization(str, k + 1, j, false);

			char operation = str.charAt(k);
			if (operation == '|') {
				if (isTrue) {
					ans += ((leftFalse * rightTrue) + (leftTrue * rightFalse) + (leftTrue * rightTrue));
				} else {
					ans += (leftFalse * rightFalse);
				}
			} else if (operation == '&') {
				if (isTrue) {
					ans += (leftTrue * rightTrue);
				} else {
					ans += ((leftFalse * rightTrue) + (leftTrue * rightFalse) + (leftFalse * rightFalse));
				}
			} else if (operation == '^') {
				if (isTrue) {
					ans += ((leftFalse * rightTrue) + (leftTrue * rightFalse));
				} else {
					ans += ((leftFalse * rightFalse) + (leftTrue * rightTrue));
				}
			}

		}

		return t[i][j][isTrue ? 1: 0]=ans%1003;
	}

	static int countWays(int n, String str) {
		t = new int[n][n][2];
		for(int i = 0 ; i < n ; i++){
		    for(int j = 0 ; j < n ; j++){
		        Arrays.fill(t[i][j], -1);
		    }
		}
		return booleanParenthesizationMemoization(str, 0, n - 1, true);
	}

}
