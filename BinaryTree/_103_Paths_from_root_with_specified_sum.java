package BinaryTree;

import java.util.ArrayList;

public class _103_Paths_from_root_with_specified_sum {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static void paths(Node root, int sum, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr) {

		if (root == null)
			return;

		else if (sum - root.data == 0) {
			curr.add(root.data);
			ans.add(new ArrayList<Integer>(curr));
			curr.remove(curr.size() - 1);
		}

		curr.add(root.data);
		paths(root.left, sum - root.data, ans, curr);
		paths(root.right, sum - root.data, ans, curr);
		curr.remove(curr.size() - 1);
	}

	public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		paths(root, sum, ans, new ArrayList<Integer>());
		return ans;
	}

}
