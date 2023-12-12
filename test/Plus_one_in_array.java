package test;

import java.util.Scanner;

public class Plus_one_in_array {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int carry = 0;
		int k = n, i = n - 1;
		int val2 = 1;
		int ans[] = new int[n + 1];
		while (k >= 0) {
			int val = ((i >= 0) ? arr[i] : 0) + val2 + carry;
			ans[k] = val % 10;
			carry = val / 10;
			i--;
			k--;
			val2 = 0;
		}
		int i1 = 0;
		for (; i1 < n + 1; i1++) {
			if (ans[i1] != 0)
				break;
		}
		String res = "[";
		for (; i1 < n + 1; i1++) {
			res += (ans[i1] + ",");
		}
		System.out.println(res.substring(0, res.length() - 1) + "]");
	}
}