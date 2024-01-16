package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class _83_Maximum_Node_Level {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static int maxNodeLevel(Node root) {

		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		int ans = 0, lvl = 0, curr = 0;

		while (!q.isEmpty()) {
			int sz = q.size();
			if (ans < sz) {
				ans = sz;
				lvl = curr;
			}

			curr++;
			while (sz-- > 0) {
				Node rem = q.remove();

				if (rem.left != null)
					q.add(rem.left);

				if (rem.right != null)
					q.add(rem.right);
			}
		}

		return lvl;
	}

}
