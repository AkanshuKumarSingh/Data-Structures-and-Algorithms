package BinarySearchTree;

import java.util.*;
import java.util.Stack;

public class _19_Find_Common_Nodes_in_two_BSTs {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static ArrayList<Integer> findCommon(Node root1, Node root2) {
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();

		while (true) {
			if (root1 != null) {
				st1.push(root1);
				root1 = root1.left;
			} else if (root2 != null) {
				st2.push(root2);
				root2 = root2.left;
			} else if (!st1.isEmpty() && !st2.isEmpty()) {
				root1 = st1.peek();
				root2 = st2.peek();

				if (root1.data == root2.data) {
					ans.add(root1.data);
					root1 = root1.right;
					root2 = root2.right;
					st1.pop();
					st2.pop();
				} else if (root1.data < root2.data) {
					root1 = root1.right;
					root2 = null;
					st1.pop();
				} else {
					root2 = root2.right;
					root1 = null;
					st2.pop();
				}

			} else {
				break;
			}
		}
		return ans;
	}

	static Set<Integer> set;
	static ArrayList<Integer> result;

	// First DFS to populate the set with elements from the first tree
	private static void dfs(Node root) {
		if (root == null)
			return;

		dfs(root.left);
		set.add(root.data);
		dfs(root.right);
	}

	// Second DFS to find common elements from the second tree
	private static void dfs2(Node root) {
		if (root == null)
			return;

		dfs2(root.left);
		if (set.contains(root.data)) {
			result.add(root.data);
		}
		dfs2(root.right);
	}

	public static ArrayList<Integer> findCommon1(Node root1, Node root2) {

		set = new HashSet<>();
		result = new ArrayList<>();

		// Perform DFS on the first tree to populate the set
		dfs(root1);

		// Perform DFS on the second tree to find common elements
		dfs2(root2);

		// Sort the result since it may not be in sorted order
		Collections.sort(result);

		return result;
	}

}
