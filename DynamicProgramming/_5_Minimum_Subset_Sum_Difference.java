package DynamicProgramming;

import java.util.ArrayList;

public class _5_Minimum_Subset_Sum_Difference {

	static boolean[][] isSubsetSumTabulation(int N, int arr[], int sum) {
		boolean t[][] = new boolean[N + 1][sum + 1];

		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (j == 0) {
					t[i][j] = true;
				} else if (i == 0) {
					t[i][j] = false;
				} else {
					boolean ans = false;
					if (j - arr[i - 1] >= 0) {
						ans = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
					} else {
						ans = t[i - 1][j];
					}
					t[i][j] = ans;
				}
			}
		}

		return t;
	}

	public int minDifference(int arr[], int n) {
		int ans = Integer.MAX_VALUE, sum = 0;
		for (int no : arr)
			sum += no;
		boolean t[][] = isSubsetSumTabulation(n, arr, sum);
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i <= sum / 2; i++) {
			if (t[n][i])
				list.add(i);
		}
		for (int no : list) {
			ans = Math.min(ans, sum - (2 * no));
		}

		return ans;
	}
}
