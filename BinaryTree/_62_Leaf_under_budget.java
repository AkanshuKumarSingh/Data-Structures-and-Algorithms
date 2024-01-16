package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class _62_Leaf_under_budget {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public int getCount(Node node, int bud) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		int level = 1, ans = 0;

		while (!q.isEmpty()) {
			int sz = q.size();
			while (sz-- > 0) {
				Node rem = q.remove();
				if (rem.left == null && rem.right == null && bud - level >= 0) {
					ans++;
					bud -= level;
				} else if (bud < level) {
					return ans;
				}

				if (rem.left != null)
					q.add(rem.left);

				if (rem.right != null)
					q.add(rem.right);
			}
			level++;
		}
		return ans;
	}

}
