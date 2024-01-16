package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class _50_Maximum_Width_of_Tree {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int getMaxWidth(Node root) {
		// System.out.println("HHM");
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		int res = 0;
		while (!q.isEmpty()) {
			int cnt = q.size();
			res = Math.max(res, cnt);
			for (int i = 0; i < cnt; i++) {
				Node curr = q.poll();
				if (curr.left != null) {
					q.offer(curr.left);
				}
				if (curr.right != null) {
					q.offer(curr.right);
				}
			}
		}
		return res;
	}

}
