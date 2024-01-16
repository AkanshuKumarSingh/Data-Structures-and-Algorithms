package BinaryTree;

import java.util.*;

public class _95_Extreme_nodes_in_alternate_order {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public ArrayList<Integer> ExtremeNode(Node node) {

		ArrayList<Integer> ans = new ArrayList<>();
		if (node == null)
			return ans;

		Queue<Node> q = new LinkedList<>();
		q.add(node);
		int lvl = 1;

		while (!q.isEmpty()) {
			int n = q.size();

			for (int i = 0; i < n; i++) {
				node = q.poll();
				if (lvl % 2 == 1 && i == n - 1) {
					ans.add(node.data);
				} else if (lvl % 2 == 0 && i == 0) {
					ans.add(node.data);
				}

				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			lvl++;
		}

		return ans;

	}

}
