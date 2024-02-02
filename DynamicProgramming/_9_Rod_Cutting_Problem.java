package DynamicProgramming;

import java.util.Arrays;

public class _9_Rod_Cutting_Problem {

	public static int cutRodRecursive(int price[], int len[], int n, int rem) {
		if (n == 0)
			return 0;
		else if (rem == 0)
			return 0;

		if (rem - len[n - 1] >= 0) {
			return Math.max(price[n - 1] + cutRodRecursive(price, len, n, rem - len[n - 1]),
					cutRodRecursive(price, len, n - 1, rem));
		} else {
			return cutRodRecursive(price, len, n - 1, rem);
		}
	}

	static int t[][];

	public static int cutRodMemoization(int price[], int len[], int n, int rem) {
		if (n == 0)
			return t[n][rem] = 0;
		else if (rem == 0)
			return t[n][rem] = 0;

		if (t[n][rem] != -1)
			return t[n][rem];

		if (rem - len[n - 1] >= 0) {
			return t[n][rem] = Math.max(price[n - 1] + cutRodMemoization(price, len, n, rem - len[n - 1]),
					cutRodMemoization(price, len, n - 1, rem));
		} else {
			return t[n][rem] = cutRodMemoization(price, len, n - 1, rem);
		}
	}

	public static int cutRod(int price[], int n) {
		t = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(t[i], -1);
		}
		int len[] = new int[n];
		for (int i = 1; i <= n; i++) {
			len[i - 1] = i;
		}
		return cutRodRecursive(price, len, n, n);
	}

	public static int cutRodTabulation(int price[], int len[], int n, int rem) {
		int t[][] = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if(i == 0 || j == 0) {
					t[i][j] = 0;
				}else {
					if(j-len[i-1] >= 0) {
						t[i][j] = Math.max(price[i-1] + t[i][j-len[i-1]], t[i-1][j]);
					}else {
						t[i][j] = t[i-1][j];
					}
				}
			}
		}
		return t[n][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
