package Array;

import java.util.Scanner;

public class _4_Bar_Chart {

	public static void main(String[] args) {
		
//		1. You are given a number n, representing the size of array a.
//		2. You are given n numbers, representing elements of array a.
//		3. You are required to print a bar chart representing value of arr a.
//		Input Format
//		A number n
//		n1
//		n2
//		.. n number of elements
//		Output Format
//		A bar chart of asteriks representing value of array a
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int arr[] = new int[n];
		int max = -1;

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
			max = Math.max(max, arr[i]);
		}

		while (max > 0) {

			for (int i = 0; i < n; i++) {
				if(arr[i] >= max) {
					System.out.print("*\t");
				}else {
					System.out.print("\t");
				}
			}
			max--;
			System.out.println();
		}

	}

}
