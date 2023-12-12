package Recursion_in_Arrays;

import java.util.Scanner;

public class Last_Index {
//	1. You are given a number n, representing the count of elements.
//	2. You are given n numbers.
//	3. You are given a number x. 
//	4. You are required to find the last index at which x occurs in array a.
//	5. If x exists in array, print the last index where it is found otherwise print -1.

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int x = scan.nextInt();
		System.out.println(lastIndex(arr, 0, x));
	}

	public static int lastIndex(int[] arr, int idx, int x) {
		
		if(idx == arr.length) {
			return -1;
		}
		
		int ans = lastIndex(arr,idx+1,x);
		if(ans != -1) {
			return ans;
		}
		
		if(arr[idx] == x) return idx;
		
		return -1;
	}

}
