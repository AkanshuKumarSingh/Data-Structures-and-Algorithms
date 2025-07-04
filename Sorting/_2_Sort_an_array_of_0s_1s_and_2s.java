package Sorting;

import java.util.Scanner;

public class _2_Sort_an_array_of_0s_1s_and_2s {
	
	// Dutch National Flag Problem

	public static void swap(int i, int j, int arr[]) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void sort012(int arr[]) {
		int i = 0, j = 0,k = arr.length-1;
		
		while(j <= k) {
			if(arr[j] == 0) {
				swap(j,i,arr);
				j++;
				i++;
			}else if(arr[j] == 1) {
				j++;
			}else {
				swap(j,k,arr);
				k--;
			}
		}
		
		for(int n : arr) {
			System.out.print(n + " ");
		}
		
	}

//	def sort012(arr):
//	    i = j = 0
//	    k = len(arr) - 1
//
//	    while j <= k:
//	        if arr[j] == 0:
//	            arr[i], arr[j] = arr[j], arr[i]
//	            i += 1
//	            j += 1
//	        elif arr[j] == 1:
//	            j += 1
//	        else:  # arr[j] == 2
//	            arr[j], arr[k] = arr[k], arr[j]
//	            k -= 1
//
//	    for num in arr:
//	        print(num, end=" ")
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		sort012(arr);
	}

}
