package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _38_Reverse_Level_Order_Traversal {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public ArrayList<Integer> reverseLevelOrder(Node node) {
		// System.out.println("JMD");
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		Stack<Integer> s = new Stack<>();
		while (!q.isEmpty()) {
			Node curr = q.poll();
			s.add(curr.data);
			if (curr.right != null)
				q.add(curr.right);
			if (curr.left != null)
				q.add(curr.left);
		}
		ArrayList<Integer> list = new ArrayList<>();
		while (!s.isEmpty()) {
			list.add(s.pop());
		}
		return list;
	}

	public ArrayList<Integer> reverseLevelOrder1(Node node) {
		// System.out.println("JMD");
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		ArrayList<Integer> list = new ArrayList<>();

		while (!q.isEmpty()) {
			Node curr = q.poll();
			list.add(curr.data);
			if (curr.right != null)
				q.add(curr.right);
			if (curr.left != null)
				q.add(curr.left);
		}
		Collections.reverse(list);
		return list;
	}

}
