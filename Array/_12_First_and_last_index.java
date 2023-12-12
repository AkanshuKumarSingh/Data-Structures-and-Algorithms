package Array;

import java.util.Scanner;

public class _12_First_and_last_index {
//	1. You are given a number n, representing the size of array a.
//	2. You are given n numbers, representing elements of array a.
//	Input Format
//	A number n
//	n1
//	n2
//	.. n number of elements
//	A number d
//	Output Format
//	A number representing first index
//	A number representing last index
	
	public static int firstIndex(int arr[], int no) {
		int start = 0, end = arr.length-1,mid = 0,l = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == no) {
				l = mid;
				end = mid-1;
			} else if (arr[mid] < no) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return l;
	}

	public static int lastIndex(int arr[], int no) {
		int start = 0, end = arr.length - 1,mid = 0,r = -1;
		
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == no) {
				r = mid;
				start = mid+1;
			} else if (arr[mid] < no) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		int no = scan.nextInt();

		int l = -1, r = -1;

		l = firstIndex(arr,no);
		r = lastIndex(arr,no);
		
		System.out.println(l);
		System.out.println(r);
	}

	
}
