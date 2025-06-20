package Sorting;

import java.util.Scanner;

public class _5_SelectionSort {
//	Time Complexity: O(n2) as there are two nested loops.
//	Auxiliary Space: O(1) 
//	The good thing about selection sort is it never makes more than O(n) swaps and can be 
//	useful when memory write is a costly operation. 

	public static void selectionSort(int[] arr) {
		for(int i = 0 ; i < arr.length - 1; i++) {
			int minIndex = i;
			for(int j = i+1; j < arr.length; j++) {
				if(isSmaller(arr,j,minIndex)) {
					minIndex = j;
				}
			}
			swap(arr,i,minIndex);
		}
	}

//	def selection_sort(arr):
//	    for i in range(len(arr) - 1):
//	        min_index = i
//	        for j in range(i + 1, len(arr)):
//	            if arr[j] < arr[min_index]:
//	                min_index = j
//	        # Inlined swap
//	        arr[i], arr[min_index] = arr[min_index], arr[i]

	
	public static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping " + arr[i] + " and " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

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
		selectionSort(arr);
		print(arr);
	}

}
