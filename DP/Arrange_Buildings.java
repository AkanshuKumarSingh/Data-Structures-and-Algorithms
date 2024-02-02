package DP;

import java.util.Scanner;

public class Arrange_Buildings {

	public static int abRecursive(int curr, int n, int building) {
		if (curr == n) {
			return 1;
		}

		int cnt = 0;
		if (building == 1) {
			cnt = (abRecursive(curr + 1, n, 0));
		} else {
			cnt = (abRecursive(curr + 1, n, 0));
			cnt += (abRecursive(curr + 1, n, 1));
		}
		return cnt;
	}

	public static long abTabulation(int n) {
		long os = 1;
		long ob = 1;
		for (int i = 2; i <= n; i++) {
			long ns = ob + os;
			long nb = os;

			os = ns;
			ob = nb;
		}

		long res = os + ob;

		return res * res;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int n1 = (abRecursive(1, n, 0));
		n1 += (abRecursive(1, n, 1));

		System.out.println(n1 * n1);

		System.out.println(abTabulation(n));
	}

}
