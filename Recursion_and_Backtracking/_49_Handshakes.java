package Recursion_and_Backtracking;

import java.util.HashMap;

public class _49_Handshakes {

	static HashMap<Integer, Integer> map = new HashMap<>();

	static int find(int n) {
		if (n % 2 == 1)
			return 0;
		if (n == 0)
			return 1;
		if (map.containsKey(n))
			return map.get(n);

		int ans = 0;
		for (int i = 1; i < n; i++) {
			ans += (find(i - 1) * find(n - i - 1));
		}
		map.put(n, ans);
		return ans;

	}

	static int count(int n) {
		if (n == 0)
			return 0;
		if (n % 2 == 1)
			return 0;
		map = new HashMap<>();
		return find(n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
