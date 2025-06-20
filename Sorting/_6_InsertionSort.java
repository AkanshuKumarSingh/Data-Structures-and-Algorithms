package Sorting;

import java.util.Scanner;

public class _6_InsertionSort {
	
//	Time Complexity: O(n^2) 
//	Auxiliary Space: O(1)
//	Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse
//	order. And it takes minimum time (Order of n) when elements are already sorted.
//	Algorithmic Paradigm: Incremental Approach
//	Sorting In Place: Yes
//	Stable: Yes

	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int j = i;
			while(j > 0 && isGreater(arr,j-1,j)) {
				swap(arr,j-1,j);
				j--;
			}
		}
	}

//	def insertion_sort(arr):
//	    for i in range(1, len(arr)):
//	        j = i
//	        while j > 0 and arr[j - 1] > arr[j]:
//	            # Inline swap
//	            arr[j - 1], arr[j] = arr[j], arr[j - 1]
//	            j -= 1
   
	// used for swapping ith and jth elements of array
	public static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping " + arr[i] + " and " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// return true if jth element is greater than ith element
	public static boolean isGreater(int[] arr, int j, int i) {
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
		insertionSort(arr);
		print(arr);
	}

}
