package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class _45_Connect_Nodes_at_Same_Level {

	static class Node {
		int data;
		Node left;
		Node right;
		Node nextRight;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
			nextRight = null;
		}
	}

	public void connect(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int sz = q.size();
			int i = 0;
			while (i < sz) {
				Node rem = q.remove();
				if (i != sz - 1) {
					rem.nextRight = q.peek();
				}

				if (rem.left != null)
					q.add(rem.left);

				if (rem.right != null)
					q.add(rem.right);

				i++;
			}
		}
	}

}
