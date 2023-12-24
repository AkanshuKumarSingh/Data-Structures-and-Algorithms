package Recursion_and_Backtracking;

import java.util.Scanner;

public class _24_Display_Array_in_Reverse {
//	1. You are given a number n, representing the size of array a.
//	2. You are given n numbers, representing elements of array a.
//	3. You are required to print the elements of array from end to beginning each in a separate line.
//	4. For the above purpose complete the body of displayArrReverse function. Don't change the signature.


	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		displayArrReverse(arr,0);
	}

	public static void displayArrReverse(int[] arr, int idx) {
		if(idx == arr.length) {
			return;
		}
		
		displayArrReverse(arr,idx+1);
		System.out.println(arr[idx]);
	}

}
