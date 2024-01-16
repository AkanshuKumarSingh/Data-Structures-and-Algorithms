package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _20_Top_View_of_Binary_Tree {

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

	static class QNode {
		Node node;
		int no;

		QNode(Node node, int no) {
			this.node = node;
			this.no = no;
		}
	}

	static ArrayList<Integer> topView(Node root) {
		HashMap<Integer, Integer> map = new HashMap<>();
		Queue<QNode> q = new LinkedList<>();
		q.offer(new QNode(root, 0));
		int min = Integer.MAX_VALUE;
		ArrayList<Integer> ans = new ArrayList<>();

		while (!q.isEmpty()) {
			QNode node = q.poll();
			if (!map.containsKey(node.no)) {
				min = Math.min(min, node.no);
				map.put(node.no, node.node.data);
			}

			if (node.node.left != null) {
				q.offer(new QNode(node.node.left, node.no - 1));
			}

			if (node.node.right != null) {
				q.offer(new QNode(node.node.right, node.no + 1));
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

	
	// GFG
    static class pair {
        Node node;
        int hd;
 
        pair() {}
        pair(Node node, int hd)
        {
            this.node = node;
            this.hd = hd;
        }
    }
    
	static void topView1(Node root) {
		// queue for holding nodes and their horizontal
		// distance from the root node
		Queue<pair> q = new LinkedList<>();

		// pushing root node with distance 0
		q.add(new pair(root, 0));

		// hd is current node's horizontal distance from
		// root node l is current left min horizontal
		// distance (or max in magnitude) so far from the
		// root node r is current right max horizontal
		// distance so far from the root node

		int hd = 0, l = 0, r = 0;

		// stack is for holding left node's data because
		// they will appear in reverse order that is why
		// using stack

		Stack<Integer> left = new Stack<>();

		// ArrayList is for holding right node's data
		ArrayList<Integer> right = new ArrayList<>();
		Node node = null;

		while (!q.isEmpty()) {
			node = q.peek().node;
			hd = q.peek().hd;

			if (hd < l) {
				left.push(node.data);
				l = hd;
			}

			if (hd > r) {
				right.add(node.data);
				r = hd;
			}

			if (node.left != null) {
				q.add(new pair(node.left, hd - 1));
			}
			if (node.right != null) {
				q.add(new pair(node.right, hd + 1));
			}

			q.poll();
		}

		// printing the left node's data in reverse order
		while (!left.isEmpty()) {
			System.out.print(left.peek() + " ");
			left.pop();
		}

		// then printing the root node's data
		System.out.print(root.data + " ");

		// finally printing the right node's data
		for (int d : right) {
			System.out.print(d + " ");
		}
	}

}
