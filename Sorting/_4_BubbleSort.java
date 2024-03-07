package Sorting;

import java.util.Scanner;

public class _4_BubbleSort {

//	Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse 
//	sorted.
//	Best Case Time Complexity: O(n). Best case occurs when array is already sorted. this will 
//	not happen in below code it happens when you define a swapped flag = false
//	Auxiliary Space: O(1)
//	Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
//	Sorting In Place: Yes
//	Stable: Yes
	
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (isSmaller(arr, j + 1, j)) {
					swap(arr, j + 1, j);
				}
			}
		}
	}

	// used for swapping ith and jth elements of array
	public static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping " + arr[i] + " and " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// return true if ith element is smaller than jth element
	public static boolean isSmaller(int[] arr, int i, int j) {
		System.out.println("Comparing " + arr[i] + " and " + arr[j]);
		if (arr[i] < arr[j]) {
			return true;
		} else {
			return false;
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		bubbleSort(arr);
		print(arr);
	}

}
