package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class _7_mergeSort {

//	Time Complexity: Sorting arrays on different machines. Merge Sort is a recursive algorithm 
//	and time complexity can be expressed as following recurrence relation. 
//	T(n) = 2T(n/2) + θ(n)
//
//	The above recurrence can be solved either using the Recurrence Tree method or the 
//	Master method. It falls in case II of Master Method and the solution of the recurrence 
//	is θ(nLogn). Time complexity of Merge Sort is  θ(nLogn) in all 3 cases (worst, average 
//	and best) as merge sort always divides the array into two halves and takes linear time
//	to merge two halves.
//	Auxiliary Space: O(n)
//	Algorithmic Paradigm: Divide and Conquer
//	Sorting In Place: No in a typical implementation
//	Stable: Yes
	
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

	public static int[] merge_sort(int arr[], int low, int high) {
		if (low == high) {
			int bres[] = new int[1];
			bres[0] = arr[low];
			return bres;
		}

		int mid = low + (high - low) / 2;
		int first_half[] = merge_sort(arr, low, mid);
		int second_half[] = merge_sort(arr, mid + 1, high);

		int res[] = mergeTwoSortedArrays(first_half, second_half);

		return res;
	}
	
//	public static void mergeTwoSortedArrays(int low, int mid, int high, int arr[]) {
//		int i = low; // without returning array
//		int j = mid + 1;
//		int k = 0;
//		int t[] = new int[high - low + 1];
//		while (i <= mid && j <= high) {
//			if (arr[i] < arr[j]) {
//				t[k++] = arr[i++];
//			} else {
//				t[k++] = arr[j++];
//			}
//		}
//
//		while (i <= mid) {
//			t[k++] = arr[i++];
//		}
//		
//		while(j <= high) {
//			t[k++] = arr[j++];
//		}
//		k = 0;
//		for(i = low; i <= high; i++) {
//			arr[i] = t[k++];
//		}
//
//	}
//
//	public static void merge_sort(int arr[], int low, int high) {
//		if (low == high) {
//			return;
//		}
//
//		int mid = low + (high - low) / 2;
//		merge_sort(arr, low, mid);
//		merge_sort(arr, mid + 1, high);
//
//		mergeTwoSortedArrays(low, mid, high, arr);
//
//	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int[] sa = merge_sort(arr, 0, arr.length - 1);
		System.out.print("Sorted Array -> ");
		System.out.println(Arrays.toString(sa));
	}

}
