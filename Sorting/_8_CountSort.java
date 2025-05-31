package Sorting;

import java.util.Scanner;

public class _8_CountSort {

	public static void countSort(int[] arr, int min, int max) {
		int map[] = new int[max - min + 1];
		for (int i = 0; i < arr.length; i++) {
			int indx = arr[i] - min;
			map[indx]++;
		}
		
		int indx = 0;
		for(int i = 0; i < map.length; i++) {
			int freq = map[i];
			int val = i + min;
			while(freq > 0) {
				arr[indx] = val;
				freq--;
				indx++;
			}
		}
		
	}
	
	public static void countSort(int[] arr,int range) {
		// for 0 - range
		int map[] = new int[range + 1];
		for (int i = 0; i < arr.length; i++) {
			int indx = arr[i];
			map[indx]++;
		}
		
		int indx = 0;
		for(int i = 0; i < map.length; i++) {
			int freq = map[i];
			while(freq > 0) {
				arr[indx] = i;
				freq--;
				indx++;
			}
		}
		
	}

//	def count_sort(arr, range_val):
//	    # For values from 0 to range_val
//	    count_map = [0] * (range_val + 1)
//
//	    for num in arr:
//	        count_map[num] += 1
//
//	    index = 0
//	    for i in range(len(count_map)):
//	        freq = count_map[i]
//	        while freq > 0:
//	            arr[index] = i
//	            index += 1
//	            freq -= 1

	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		countSort(arr, min, max);
		print(arr);
	}

}
