package Time_and_space;

import java.util.Scanner;

public class RadixSort {

	public static void radixSort(int[] arr) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int exp = 1;
		while (exp <= max) {
			countSortForRadix(arr, exp);
			exp *= 10;
		}
		
	}

	public static void countSortForRadix(int[] arr, int exp) {
		int freq[] = new int[10];

		for (int i = 0; i < arr.length; i++) {
			int indx = (arr[i] / exp) % 10;
			freq[indx]++;
		}

		for (int i = 1; i < 10; i++) {
			freq[i] += freq[i - 1];
		}

		int ans[] = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			int indx = (arr[i] / exp) % 10;
			int pos = freq[indx];
			ans[pos-1] = arr[i];
			freq[indx]--;
		}

		for(int i = 0 ; i < arr.length; i++) {
			arr[i] = ans[i];
		}
		
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
		radixSort(arr);
		print(arr);
	}

}
