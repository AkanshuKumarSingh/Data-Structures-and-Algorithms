package Recursion_and_Backtracking;

import java.util.Scanner;

public class _30_Target_sum_subset {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int tar = scan.nextInt();
		printTargetSumSubsets(arr, 0, "", 0, tar);

	}

	public static void printTargetSumSubsets(int[] arr, int idx, String asf, int sos, int tar) {

		if (idx == arr.length) {
			if(sos == tar)
				System.out.println(asf + ".");
			return;
		}

		if (sos + arr[idx] <= tar) {
			printTargetSumSubsets(arr, idx + 1, asf + arr[idx] + ",", sos + arr[idx], tar);
		}
		printTargetSumSubsets(arr, idx + 1, asf, sos, tar);
		

	}

}
