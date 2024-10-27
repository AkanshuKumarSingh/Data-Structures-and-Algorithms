package DynamicProgramming;

import java.util.*;

public class _58_Minimum_Cost_to_Cut_Stick {

    public static int minCost1(int n, int[] cuts) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		for (int i : cuts)
			list.add(i);
		list.add(n);
		Collections.sort(list);

		int dp[][] = new int[cuts.length + 2][cuts.length + 1];
		for (int i = cuts.length + 1; i >= 1; i--) {
			for (int j = 0; j <= cuts.length; j++) {
				if (i > j){
					dp[i][j] = 0;
                }else {
					int min = Integer.MAX_VALUE;
					for (int k = i; k <= j; k++) {
						int val = dp[i][k - 1] + dp[k + 1][j] + list.get(j + 1) - list.get(i - 1);
						min = Math.min(min, val);
					}
					dp[i][j] = min;

				}
			}
		}

		return dp[1][cuts.length];
    }

	public int fxn(int i, int j, ArrayList<Integer> cuts, int dp[][]) {
		if (i > j)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];

		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j; k++) {
			int val = fxn(i, k - 1, cuts, dp) + fxn(k + 1, j, cuts, dp) + cuts.get(j + 1) - cuts.get(i - 1);
			min = Math.min(min, val);
		}
		return dp[i][j] = min;
	}

	public int minCost(int n, int[] cuts) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		for (int i : cuts)
			list.add(i);
		list.add(n);
		Collections.sort(list);

		int dp[][] = new int[cuts.length + 2][cuts.length + 1];
		for (int i = 0; i < cuts.length + 1; i++)
			Arrays.fill(dp[i], -1);
		return fxn(1, cuts.length, list, dp);
	}

	public static void main(String args[]) {
		System.out.println(minCost1(7, new int[] { 1, 3, 4, 5 }));
	}

}
