package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class _3_Merge_two_sorted_arrays {

	public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
		int i = 0;
		int j = 0;
		int k = 0;
		int ans[] = new int[a.length + b.length];

		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				ans[k++] = a[i++];
			} else {
				ans[k++] = b[j++];
			}
		}

		while (i < a.length) {
			ans[k++] = a[i++];
		}
		while (j < b.length) {
			ans[k++] = b[j++];
		}

		return ans;
		
	}

//	def merge_two_sorted_arrays(a, b):
//	    i = j = k = 0
//	    ans = [0] * (len(a) + len(b))
//
//	    while i < len(a) and j < len(b):
//	        if a[i] < b[j]:
//	            ans[k] = a[i]
//	            i += 1
//	        else:
//	            ans[k] = b[j]
//	            j += 1
//	        k += 1
//
//	    while i < len(a):
//	        ans[k] = a[i]
//	        i += 1
//	        k += 1
//
//	    while j < len(b):
//	        ans[k] = b[j]
//	        j += 1
//	        k += 1
//
//	    return ans

	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.nextInt();
		}
		int m = scn.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = scn.nextInt();
		}
		int[] mergedArray = mergeTwoSortedArrays(a, b);
		System.out.println(Arrays.toString(mergedArray));
		print(mergedArray);
	}
}
