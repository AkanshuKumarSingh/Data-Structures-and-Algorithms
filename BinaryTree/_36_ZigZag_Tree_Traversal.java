package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class _36_ZigZag_Tree_Traversal {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	ArrayList<Integer> zigZagTraversal(Node root) {
		Stack<Node> mainS = new Stack<>();
		Stack<Node> helperS = new Stack<>();

		mainS.push(root);
		ArrayList<Integer> list = new ArrayList<>();
		int ht = 0;

		while (!mainS.isEmpty()) {

			while (!mainS.isEmpty()) {
				Node curr = mainS.pop();

				list.add(curr.data);
				if (ht % 2 == 0) {
					if (curr.left != null)
						helperS.push(curr.left);
					if (curr.right != null)
						helperS.push(curr.right);
				} else {
					if (curr.right != null)
						helperS.push(curr.right);
					if (curr.left != null)
						helperS.push(curr.left);
				}
			}

			Stack<Node> t = mainS;
			mainS = helperS;
			helperS = t;

			ht++;
		}

		return list;
	}

}
