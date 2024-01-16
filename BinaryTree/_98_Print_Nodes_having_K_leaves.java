package BinaryTree;

import java.util.ArrayList;

public class _98_Print_Nodes_having_K_leaves {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public int findNodes(Node root, int k, ArrayList<Integer> ans) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int sum = findNodes(root.left, k, ans) + findNodes(root.right, k, ans);
		if (sum == k) {
			ans.add(root.data);
		}
		return sum;

	}

	public ArrayList<Integer> btWithKleaves(Node root, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (k == 0)
			return ans;
		findNodes(root, k, ans);
		if (ans.size() == 0)
			ans.add(-1);
		return ans;
	}

}
