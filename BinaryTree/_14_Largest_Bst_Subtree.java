package BinaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _14_Largest_Bst_Subtree {
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

	public static class BSTPair {
		int min;
		int max;
		boolean isBST;
		int size;

		BSTPair() {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			isBST = true;
			size = 0;
		}
	}

	static int size = 0;
	static int larBSTNode = 0;

	public static BSTPair largestBSTSubtree(Node node) {
        if(node == null) return new BSTPair();

		BSTPair left = largestBSTSubtree(node.left);
		BSTPair right = largestBSTSubtree(node.right);

		boolean res = left.max < node.data && right.min > node.data;
		
		BSTPair curr = new BSTPair();
		curr.min = Math.min(node.data, Math.min(left.min, right.min));
		curr.max = Math.max(node.data, Math.max(left.max, right.max));
		curr.isBST = res && left.isBST && right.isBST;
		curr.size = left.size + right.size + 1;
		
		if(curr.isBST && curr.size > size) {
			size = curr.size;
			larBSTNode = node.data;
		}
		
		return curr;
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

		Node root = construct(arr);
		largestBSTSubtree(root);
		System.out.println(larBSTNode + "@" + size);

	}

}
