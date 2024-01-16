package BinaryTree;

import java.util.Stack;

public class _1_binaryTree {

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

	public static class Pair {
		Node node;
		int state;

		Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	static int indx = 0;
	public static Node constructRecursive(Integer[] data) {
		if(data[indx] == null) {
			return null;
		}
		
		Node node = new Node(data[indx]);
		indx++;
		node.left = constructRecursive(data);
		indx++;
		node.right = constructRecursive(data);
		
		return node;
		
	}
	
	public static Node construct(Integer[] data) {
		Stack<Pair> st = new Stack<>();

		Node root = new Node(data[0]);
		int indx = 1;
		st.push(new Pair(root, -1));

		while (st.size() > 0) {
			Pair p = st.peek();

			if (p.state == -1) {
				// left child addition
				if (data[indx] != null) {
					// add only if child is not null
					Node nn = new Node(data[indx]);
					p.node.left = nn;
					st.push(new Pair(nn, -1));
				}
				p.state++;
				indx++;
			} else if (p.state == 0) {
				// right child addition
				if (data[indx] != null) {
					// add only if child is not null
					Node nn = new Node(data[indx]);
					p.node.right = nn;
					st.push(new Pair(nn, -1));
				}
				p.state++;
				indx++;
			} else {
				st.pop();
			}

		}
		return root;
	}

	public static void display(Node root) {
		if (root == null) {
			return;
		}
		String str = "";
		str += root.left == null?".":root.left.data;
		str += " <- [" + root.data + "] -> ";
		str += root.right == null?".":root.right.data;
		System.out.println(str);
//		System.out.println(root.left + " <- " + root + " -> " + root.right);
		display(root.left);
		display(root.right);
	}

	public static void main(String[] args) {
		Integer data[] = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
				null };
		Node root = construct(data);
		display(root);
		System.out.println("\n");
		display(constructRecursive(data));
	}

}
