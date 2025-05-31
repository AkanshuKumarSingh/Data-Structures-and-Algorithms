package Sorting;

import java.util.Scanner;

public class _10_QuickSort {

//	Time Complexity:
//		  Best/Average: O(n log n)
//		  Worst: O(n²)
//
//		Space Complexity:
//		  Best/Average: O(log n)
//		  Worst: O(n)
//
//		Explanation:
//		- In-place sort → no extra array space.
//		- Recursive call stack depth depends on partition balance.
//
	
	public static void quickSort(int[] arr, int low, int high) {
		if (low > high)
			return;

		int pivot = arr[high];
		int partitionIndex = partition(arr, pivot, low, high);
		quickSort(arr, low, partitionIndex - 1);
		quickSort(arr, partitionIndex + 1, high);
	}

	public static int partition(int[] arr, int pivot, int lo, int hi) {
		System.out.println("pivot -> " + pivot);
		int i = lo, j = lo;
		while (i <= hi) {
			if (arr[i] <= pivot) {
				swap(arr, i, j);
				i++;
				j++;
			} else {
				i++;
			}
		}
		System.out.println("pivot index -> " + (j - 1));
		return (j - 1);
	}

	// used for swapping ith and jth elements of array
	public static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping " + arr[i] + " and " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


//def partition(arr, pivot, lo, hi):
//    print("pivot ->", pivot)
//    i = lo
//    j = lo
//    while i <= hi:
//        if arr[i] <= pivot:
//            arr[i], arr[j] = arr[j], arr[i]
//            i += 1
//            j += 1
//        else:
//            i += 1
//    print("pivot index ->", j - 1)
//    return j - 1
//
//def quickSort(arr, low, high):
//    if low > high:
//        return
//    pivot = arr[high]
//    partitionIndex = partition(arr, pivot, low, high)
//    quickSort(arr, low, partitionIndex - 1)
//    quickSort(arr, partitionIndex + 1, high)
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		quickSort(arr, 0, arr.length - 1);
		print(arr);
	}

}
