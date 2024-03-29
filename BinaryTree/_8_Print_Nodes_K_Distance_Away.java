package BinaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

import BinaryTree._7_Print_K_Levels_Down.Node;

public class _8_Print_Nodes_K_Distance_Away {
	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
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

	public static Node construct(Integer[] arr) {
		Node root = new Node(arr[0], null, null);
		Pair rtp = new Pair(root, 1);

		Stack<Pair> st = new Stack<>();
		st.push(rtp);

		int idx = 0;
		while (st.size() > 0) {
			Pair top = st.peek();
			if (top.state == 1) {
				idx++;
				if (arr[idx] != null) {
					top.node.left = new Node(arr[idx], null, null);
					Pair lp = new Pair(top.node.left, 1);
					st.push(lp);
				} else {
					top.node.left = null;
				}

				top.state++;
			} else if (top.state == 2) {
				idx++;
				if (arr[idx] != null) {
					top.node.right = new Node(arr[idx], null, null);
					Pair rp = new Pair(top.node.right, 1);
					st.push(rp);
				} else {
					top.node.right = null;
				}

				top.state++;
			} else {
				st.pop();
			}
		}

		return root;
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		str += node.left == null ? "." : node.left.data + "";
		str += " <- " + node.data + " -> ";
		str += node.right == null ? "." : node.right.data + "";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void printKDown(Node node, Node blockage, int k) {
		if (node == null || node == blockage)
			return;

		if (k == 0) {
			System.out.println(node.data);
			return;
		}

		printKDown(node.left, blockage, k - 1);
		printKDown(node.right, blockage, k - 1);
	}

	public static ArrayList<Node> nodeToRootPath(Node root, int data) {
		if (root == null)
			return new ArrayList<Node>();

		if (root.data == data) {
			ArrayList<Node> cres = new ArrayList<Node>();
			cres.add(root);
			return cres;
		}

		ArrayList<Node> lres = nodeToRootPath(root.left, data);
		if (!lres.isEmpty()) {
			lres.add(root);
			return lres;
		}

		ArrayList<Node> rres = nodeToRootPath(root.right, data);
		if (!rres.isEmpty()) {
			rres.add(root);
			return rres;
		}

		return new ArrayList<Node>();
	}

	public static void printKNodesFar(Node node, int data, int k) {
		ArrayList<Node> path = nodeToRootPath(node, data);
		Node blockage = null;

		for (int i = 0; i < path.size() && k - i >= 0; i++) {
			Node nroot = path.get(i);
			printKDown(nroot, blockage, k - i);
			blockage = nroot;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];
		String[] values = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			if (values[i].equals("n") == false) {
				arr[i] = Integer.parseInt(values[i]);
			} else {
				arr[i] = null;
			}
		}

		int data = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		Node root = construct(arr);
		printKNodesFar(root, data, k);
	}

}
