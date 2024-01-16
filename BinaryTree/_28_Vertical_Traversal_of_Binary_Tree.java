package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _28_Vertical_Traversal_of_Binary_Tree {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static class QNode {
		Node node;
		int dis;

		QNode(Node node, int dis) {
			this.node = node;
			this.dis = dis;
		}
	}

	// Function to find the vertical order traversal of Binary Tree.
	static ArrayList<Integer> verticalOrder(Node root) {
		Queue<QNode> q = new LinkedList<>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		q.offer(new QNode(root, 0));
		int min = 0;
		ArrayList<Integer> ans = new ArrayList<>();

		while (!q.isEmpty()) {
			QNode curr = q.poll();
			ArrayList<Integer> list = map.getOrDefault(curr.dis, new ArrayList<Integer>());
			list.add(curr.node.data);
			map.put(curr.dis, list);
			min = Math.min(min, curr.dis);

			if (curr.node.left != null) {
				q.offer(new QNode(curr.node.left, curr.dis - 1));
			}

			if (curr.node.right != null) {
				q.offer(new QNode(curr.node.right, curr.dis + 1));
			}
		}

		while (true) {
			if (map.containsKey(min)) {
				ArrayList<Integer> list = map.get(min);
				for (int no : list) {
					ans.add(no);
				}
			} else {
				break;
			}
			min++;
		}

		return ans;
	}

}
