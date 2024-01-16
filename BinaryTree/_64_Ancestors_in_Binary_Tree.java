package BinaryTree;

import java.util.ArrayList;

public class _64_Ancestors_in_Binary_Tree {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static ArrayList<Integer> Ancestors(Node root, int target) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		if (root.left != null || root.right != null) {
			if ((root.left != null && root.left.data == target) || (root.right != null && root.right.data == target)) {
				ans.add(root.data);
				return ans;
			}
		}

		ans = Ancestors(root.left, target);
		if (!ans.isEmpty()) {
			ans.add(root.data);
			return ans;
		}

		ans = Ancestors(root.right, target);
		if (!ans.isEmpty()) {
			ans.add(root.data);
		}
		return ans;

	}

}
