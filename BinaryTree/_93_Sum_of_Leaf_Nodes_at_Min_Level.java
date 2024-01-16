package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class _93_Sum_of_Leaf_Nodes_at_Min_Level {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public int minLeafSum(Node node) {
		if (node == null)
			return 0;

		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while (!q.isEmpty()) {
			int n = q.size();
			int sum = 0;
			boolean flag = false;

			for (int i = 0; i < n; i++) {
				node = q.poll();
				if (node.left == null && node.right == null) {
					flag = true;
					sum += node.data;
				}

				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			if (flag)
				return sum;
		}

		return 0;
	}

}
