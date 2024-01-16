package BinaryTree;

import java.util.*;

public class _31_Right_View_of_Binary_Tree {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	ArrayList<Integer> rightView(Node root) {
		if (root == null)
			return new ArrayList<Integer>();
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		ArrayList<Integer> ans = new ArrayList<>();

		while (!q.isEmpty()) {
			int sz = q.size();
			while (sz-- > 0) {
				Node node = q.poll();
				if (sz == 0)
					ans.add(node.data);

				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}

		}

		return ans;
	}

}
