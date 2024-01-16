package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _24_Bottom_View_of_Binary_Tree {

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

	// Function to return a list containing the bottom view of the given tree.
	public ArrayList<Integer> bottomView(Node root) {
		Queue<QNode> q = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		q.offer(new QNode(root, 0));
		int min = 0;
		ArrayList<Integer> ans = new ArrayList<>();

		while (!q.isEmpty()) {
			QNode curr = q.poll();

			min = Math.min(min, curr.dis);
			map.put(curr.dis, curr.node.data);
			if (curr.node.left != null) {
				q.offer(new QNode(curr.node.left, curr.dis - 1));
			}

			if (curr.node.right != null) {
				q.offer(new QNode(curr.node.right, curr.dis + 1));
			}

		}

		while (true) {
			if (map.containsKey(min))
				ans.add(map.get(min));
			else
				break;
			min++;
		}

		return ans;

	}

}
