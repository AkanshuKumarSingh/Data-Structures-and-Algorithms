package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Paint_House_Many_Colors {

	public static int phTabulationSirOn3(int arr[][]) {
		int n = arr.length;
		int k = arr[0].length;
		int dp[] = new int[k];
		for (int i = 0; i < k; i++) {
			dp[i] = arr[0][i];
		}

		for (int i = 1; i < arr.length; i++) {
			int n_dp[] = new int[k];
			for (int j = 0; j < k; j++) {
				int min = Integer.MAX_VALUE;
				for (int indx = 0; indx < k; indx++) {
					if (indx == j)
						continue;
					min = Math.min(min, dp[indx]);
				}
				n_dp[j] = min + arr[i][j];
			}
			dp = n_dp;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < k; i++) {
			ans = Math.min(ans, dp[i]);
		}
		return ans;
	}

	public static int phTabulationSir(int arr[][]) {
		int n = arr.length;
		int k = arr[0].length;
		int dp[] = new int[k];

		int min = Integer.MAX_VALUE;
		int s_min = Integer.MAX_VALUE;
		
		for (int i = 0; i < k; i++) {
			dp[i] = arr[0][i];
			if (dp[i] < min) {
				s_min = min;
				min = dp[i];
			} else if (dp[i] < s_min) {
				s_min = dp[i];
			}

		}

		for (int i = 1; i < arr.length; i++) {
			int n_dp[] = new int[k];
			int min2 = Integer.MAX_VALUE;
			int s_min2 = Integer.MAX_VALUE;
			for (int j = 0; j < k; j++) {
				if(dp[j] == min) {
					n_dp[j] = s_min + arr[i][j];
				}else {
					n_dp[j] = min + arr[i][j];
				}
				
				if(min2 > n_dp[j]) {
					s_min2 = min2;
					min2 = n_dp[j];
				}else if(s_min2 > n_dp[j]) {
					s_min2 = n_dp[j];
				}
				
			}
			
			min = min2;
			s_min = s_min2;
			dp = n_dp;
		}
		
		return min;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int mat[][] = new int[n][k];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				mat[i][j] = scan.nextInt();
			}
		}
		System.out.println(phTabulationSir(mat));
	}

}
