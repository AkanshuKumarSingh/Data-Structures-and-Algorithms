package BinarySearchTree;

import java.util.*;

public class _23_Merge_two_BSTs {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}
	
	public List<Integer> merge(Node root1, Node root2) {
		Stack<Node> st1 = new Stack<>();
		Stack<Node> st2 = new Stack<>();
		List<Integer> ans = new ArrayList<>();

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
					ans.add(root2.data);
					st1.pop();
					st2.pop();
					root1 = root1.right;
					root2 = root2.right;
				} else if (root1.data < root2.data) {
					ans.add(root1.data);
					st1.pop();
					root1 = root1.right;
					root2 = null;
				} else {
					ans.add(root2.data);
					st2.pop();
					root2 = root2.right;
					root1 = null;
				}
			} else if (!st1.isEmpty()) {
				root1 = st1.pop();
				ans.add(root1.data);
				root1 = root1.right;
			} else if (!st2.isEmpty()) {
				root2 = st2.pop();
				ans.add(root2.data);
				root2 = root2.right;
			} else {
				break;
			}
		}

		return ans;
	}

}
