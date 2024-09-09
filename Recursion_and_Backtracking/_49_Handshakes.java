package Recursion_and_Backtracking;

import java.util.HashMap;

public class _49_Handshakes {

//	Other applications of catalan numbers
//	Count the number of expressions containing n pairs of parentheses that are correctly matched. For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).
//	Count the number of possible Binary Search Trees with n keys (See this)
//	Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.
//	Given a number n, return the number of ways you can draw n chords in a circle with 2 x n points such that no 2 chords intersect.
	
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
