package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _3_Reverse_an_array {
//	1. You are given a number n, representing the size of array a.
//	2. You are given n numbers, representing elements of array a.
//	3. You are required to reverse the contents of array a.


	public static void display(int[] a) {
		StringBuilder sb = new StringBuilder();

		for (int val : a) {
			sb.append(val + " ");
		}
		System.out.println(sb);
	}

	public static void reverse(int[] a) {
		int n = a.length;
		for(int i = 0 ; i < n/2; i++) {
			int t = a[i];
			a[i] = a[n-1-i];
			a[n-i-1] = t;
		}
		
//		int left = 0,right = n-1; also good;
//		while(left < right) {
//			int t = a[left];
//			a[left] = a[right];
//			a[right] = t;
//			left++;
//			right--;		
//		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		reverse(a);
		display(a);
	}

}
