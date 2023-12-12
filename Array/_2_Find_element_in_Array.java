package Array;

import java.util.Scanner;

public class _2_Find_element_in_Array {
//	1.You are given a number n, representing the size of array a.
//	2.You are given n distinct numbers, representing elements of array a.
//	3. You are given another number d.
//	4. You are required to check if d number exists in the array a and at what index (0 based). If found print the index, otherwise print -1.

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		int d = scan.nextInt();
		int index = -1;

		for (int i = 0; i < n; i++) {
			if (arr[i] == d) {
				index = i;
				break;
			}
		}

		System.out.println(index);
	}

}
