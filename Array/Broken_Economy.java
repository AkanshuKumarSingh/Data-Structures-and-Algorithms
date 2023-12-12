package Array;

import java.util.Scanner;

public class Broken_Economy {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}

		int no = scan.nextInt();

		int start = 0, end = n - 1,mid = 0;

		while (start <= end) {
			mid = start + (end - start) / 2;
			if (arr[mid] == no) {
				break;
			} else if (arr[mid] < no) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		if(start <= end) {
			System.out.println(arr[mid]);
		}else {
			System.out.println(arr[start]);
			System.out.println(arr[end]);
		}
	}

}
