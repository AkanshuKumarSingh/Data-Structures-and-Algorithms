package BinaryTree;

import java.util.*;

public class _85_Find_the_Node_with_maximum_GCD_of_the_siblings_of_Binary_Tree {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int maxGCD(Node root) {

		int maxGCD = 0;
		int ans = 0;

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node u = q.poll();

			boolean left = false, right = false;

			if (u.left != null) {
				q.add(u.left);
				left = true;
			}

			if (u.right != null) {
				q.add(u.right);
				right = true;
			}

			if (left && right) {
				int gcd = gcd(u.left.data, u.right.data);
				if (gcd >= maxGCD) {
					maxGCD = gcd;
					ans = u.data;
				}
			}
		}

		return ans;

	}

	int gcd(int a, int b) {

		if (a % b == 0)
			return b;

		if (a < b)
			return gcd(b, a);

		return gcd(b, a % b);

	}

}
