package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

import BinaryTree._1_binaryTree.Node;

public class _58_Serialize_and_Deserialize_Binary_Tree {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}

		public String toString() {
			return "" + data;
		}
	}

	static int Empty = -1;

	public void serialize(Node root, ArrayList<Integer> A) {
		if (root == null) {
			A.add(Empty);
			return;
		}
		;
		A.add(root.data);
		serialize(root.left, A);
		serialize(root.right, A);
	}

	// Function to deserialize a list and construct the tree.

	static class Pair {
		Node node;
		int state;

		Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public Node deSerialize(ArrayList<Integer> A) {
		Node head = new Node(A.get(0));
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(head, 0));
		int i = 1;

		while (i < A.size()) {
			Pair pair = st.peek();
			int no = A.get(i);

			i++;
			if (pair.state == 0) {
				pair.state++;
				if (no == -1)
					continue;
				Node newNode = new Node(no);
				pair.node.left = newNode;
				st.push(new Pair(newNode, 0));
			} else if (pair.state == 1) {
				pair.state++;
				if (no == -1)
					continue;
				Node newNode = new Node(no);
				pair.node.right = newNode;
				st.push(new Pair(newNode, 0));
			} else {
				i--;
				st.pop();
			}

		}
		return head;
	}

	// 2nd way
	int i = 0;
	Node root = null;

	public Node deSerialize1(ArrayList<Integer> A) {
		if (i >= A.size()) {
			return null;
		}
		if (A.get(i) == -1) {
			i++;
			return null;
		}
		Node node = new Node(A.get(i++));
		if (root == null) {
			root = node;
		}
		node.left = deSerialize(A);
		node.right = deSerialize(A);
		return node;
	}

}
