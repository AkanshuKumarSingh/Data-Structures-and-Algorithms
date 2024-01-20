package Hashing;

import java.util.Arrays;

public class _10_Triplet_Sum_in_Array {
	
	public static boolean find3Numbers(int A[], int n, int X) {
		Arrays.sort(A);
		for (int i = 0; i < n; i++) {
			int no = X - A[i];
			int st = i + 1, ed = n - 1;
			while (st < ed) {
				if (A[st] + A[ed] == no) {
					return true;
				} else if (A[st] + A[ed] < no) {
					st++;
				} else {
					ed--;
				}
			}
		}
		return false;
	}
	
}
