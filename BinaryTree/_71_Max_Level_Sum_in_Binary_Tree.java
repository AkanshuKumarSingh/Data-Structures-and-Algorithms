package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class _71_Max_Level_Sum_in_Binary_Tree {

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

	public int maxLevelSum(Node node) {

		Queue<Node> q = new LinkedList<>();
		q.add(node);
		int max = Integer.MIN_VALUE, curr = Integer.MIN_VALUE;

		while (!q.isEmpty()) {
			int sz = q.size();
			curr = 0;
			while (sz-- > 0) {
				Node rem = q.remove();
				curr += rem.data;

				if (rem.left != null)
					q.add(rem.left);

				if (rem.right != null)
					q.add(rem.right);
			}
			max = Math.max(max, curr);
		}

		return max;
	}

}
