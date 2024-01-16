package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class _76_Odd_even_level_difference {

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

	int getLevelDiff(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		int oddLevel = 0, evenLevel = 0, lvl = 1;

		while (!q.isEmpty()) {
			int sz = q.size();

			while (sz-- > 0) {
				Node rem = q.remove();
				if (lvl % 2 == 1)
					oddLevel += rem.data;
				else
					evenLevel += rem.data;

				if (rem.left != null)
					q.add(rem.left);

				if (rem.right != null)
					q.add(rem.right);
			}
			lvl++;
		}

		return oddLevel - evenLevel;
	}

}
