package BinaryTree;

import java.util.*;

public class _84_Diagonal_Sum_In_Binary_Tree {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public static ArrayList<Integer> diagonalSum(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		ArrayList<Integer> ans = new ArrayList<>();

		while (!q.isEmpty()) {
			int sz = q.size(), sum = 0;
			for (int i = 0; i < sz; i++) {
				Node curr = q.poll();
				while (curr != null) {
					sum += curr.data;
					if (curr.left != null) {
						q.offer(curr.left);
					}
					curr = curr.right;
				}
			}
			ans.add(sum);
		}
		return ans;
	}

}
