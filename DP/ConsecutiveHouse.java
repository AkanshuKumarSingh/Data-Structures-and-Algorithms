package DP;

public class ConsecutiveHouse {

	public static int find(int n, int c, int v) {
//		System.out.println(n + " " + c + " " + v);
		if (v == 0) {
			return 1;
		}
		if (n <= 0) {
			return 0;
		}

		int cnt = 0;
		for (int i = 1; i <= c && i <= n; i++) {
			if (v - i >= 0) {
				cnt += (find(n - i - 1, c, v - i));
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		int n = 7;
		int c = 3;
		int v = 5;
//		int n = 4;
//		int c = 2;
//		int v = 2;
		System.out.println(find(n, c, v));
	}

}
