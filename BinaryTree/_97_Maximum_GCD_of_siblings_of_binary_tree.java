package BinaryTree;

import java.util.* ;

public class _97_Maximum_GCD_of_siblings_of_binary_tree {

	static int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxGcd = 0;

		for (ArrayList<Integer> curr : arr) {
			int node = curr.get(0);
			int left = curr.get(1);

			int right = map.getOrDefault(node, 0);
			if (right == 0) {
				map.put(node, left);
			} else {
				int gcd = getGcd(left, right);
				maxGcd = Math.max(gcd, maxGcd);
				map.remove(node);
			}

		}
		return maxGcd;
	}

	static int getGcd(int a, int b) {
		int rem = 1;
		while (rem != 0) {
			rem = a % b;
			a = b;
			b = rem;
		}
		return a;
	}
}
