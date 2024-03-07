package Sorting;

import java.util.Scanner;

public class _1_Segregate_0s_and_1s {
	
	public static void swap(int i, int j, int arr[]) {
		int t = arr[j];
		arr[j] = arr[i];
		arr[i] = t;
	}

	public static void sort01(int arr[]) {
		int i = 0, j = 0;
		while (j < arr.length) {
			if (arr[j] == 1) {
				j++;
			} else {
				swap(j,i,arr);
				i++;
				j++;
			}
		}

		for (int no : arr) {
			System.out.print(no + " ");
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		sort01(arr);

	}

}
