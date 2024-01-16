package BinaryTree;

import java.util.*;

public class _78_Vertical_sum {

	static class Node {
		int data;
		Node left, right;

		Node(int item)
		{
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

	public ArrayList<Integer> verticalSum(Node root) {
		Queue<QNode> q = new LinkedList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		q.offer(new QNode(root, 0));
		int min = 0;
		ArrayList<Integer> ans = new ArrayList<>();

		while (!q.isEmpty()) {
			QNode curr = q.poll();
			int sum = map.getOrDefault(curr.dis, 0);
			sum += curr.node.data;
			map.put(curr.dis, sum);
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
				ans.add(map.get(min));
			} else {
				break;
			}
			min++;
		}

		return ans;
	}

}
