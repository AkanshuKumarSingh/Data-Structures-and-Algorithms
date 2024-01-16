package BinaryTree;

import java.util.*;

public class _96_Largest_value_in_each_level {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public ArrayList<Integer> largestValues(Node node) {

		// System.out.println("HHM");
		ArrayList<Integer> ans = new ArrayList<>();
		if (node == null)
			return ans;

		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while (!q.isEmpty()) {
			int n = q.size();
			int max = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++) {
				node = q.poll();
				max = Math.max(max, node.data);

				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			ans.add(max);
		}

		return ans;

	}

}
