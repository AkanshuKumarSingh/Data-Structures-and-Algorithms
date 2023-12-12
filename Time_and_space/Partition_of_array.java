package Time_and_space;

import java.util.Scanner;

public class Partition_of_array {

	public static void partition(int[] arr, int pivot) {
//		int j = 0;
//		for(int i = 0 ; i < arr.length; i++) {
//			if(arr[i] <= pivot) {
//				swap(arr,i,j);
//				j++;
//			}
//		}
		
		int i = 0;
		int j = 0;
		while(j < arr.length) {
			if(arr[i] <= pivot) {
				swap(arr,i,j);
				i++;
				j++;
			}else {
				j++;
			}
		}
	// return i-1 -- partition index
	}

	// used for swapping ith and jth elements of array
	public static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping " + arr[i] + " and " + arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

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
		int pivot = scn.nextInt();
		partition(arr, pivot);
		print(arr);
	}
}
