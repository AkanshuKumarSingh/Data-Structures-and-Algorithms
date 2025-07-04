package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _13_Rotate_an_array {
//	1. You are given a number n, representing the size of array a.
//	2. You are given n numbers, representing elements of array a.
//	3. You are given a number k.
//	4. Rotate the array a, k times to the right (for positive values of k), and to
//	the left for negative values of k.


	public static void display(int[] a) {
		StringBuilder sb = new StringBuilder();

		for (int val : a) {
			sb.append(val + " ");
		}
		System.out.println(sb);
	}

	public static void reverse(int a[], int left, int right) {
		while (left < right) {
			int t = a[left];
			a[left] = a[right];
			a[right] = t;
			left++;
			right--;
		}
	}

	public static void rotate(int[] a, int k) {
		k = k % a.length;
		if (k < 0) {
			k = k + a.length;
		}
		reverse(a,0,a.length-1);
		reverse(a,0,k-1);
		reverse(a,k,a.length-1);
	}

//	def reverse(a, left, right):
//	    while left < right:
//	        a[left], a[right] = a[right], a[left]
//	        left += 1
//	        right -= 1
//
//	def rotate(a, k):
//	    k = k % len(a)
//	    if k < 0:
//	        k += len(a)
//	    reverse(a, 0, len(a) - 1)
//	    reverse(a, 0, k - 1)
//	    reverse(a, k, len(a) - 1)

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		int k = Integer.parseInt(br.readLine());

		rotate(a, k);
		display(a);
	}

}
