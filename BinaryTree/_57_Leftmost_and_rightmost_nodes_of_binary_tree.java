package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class _57_Leftmost_and_rightmost_nodes_of_binary_tree {

	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	public static void printCorner(Node node) {

		Queue<Node> q = new LinkedList<>();
		q.add(node);

		while (!q.isEmpty()) {
			int sz = q.size(), i = 1;
			while (i <= sz) {
				Node rem = q.remove();

				if (i == 1 || i == sz)
					System.out.print(rem.data + " ");

				if (rem.left != null)
					q.add(rem.left);

				if (rem.right != null)
					q.add(rem.right);

				i++;
			}
		}
	}
	
}
