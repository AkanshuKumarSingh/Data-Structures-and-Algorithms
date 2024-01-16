package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _49_Diagonal_Traversal_of_Binary_Tree {

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

	public ArrayList<Integer> diagonal(Node root) {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		int sz = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node curr = q.poll();
				while (curr != null) {
					if (curr.left != null) {
						q.offer(curr.left);
					}
					ans.add(curr.data);
					curr = curr.right;
				}
			}
		}

		return ans;
	}

}
