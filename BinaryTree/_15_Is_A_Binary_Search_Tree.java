package BinaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

import BinaryTree._2_Size_Sum_Maximum_And_Height_Of_Binary_Tree.Node;

public class _15_Is_A_Binary_Search_Tree {
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

	public static int height(Node node) {
		if (node == null) {
			return -1;
		}

		int lh = height(node.left);
		int rh = height(node.right);

		int th = Math.max(lh, rh) + 1;
		return th;
	}

	public static class BSTPair {
		int min;
		int max;
		boolean isBST;

		BSTPair() {
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			isBST = true;
		}
	}

	public static BSTPair isBST(Node root) {
		//O(n)
		if(root == null) return new BSTPair();
		
		BSTPair left = isBST(root.left);
		BSTPair right = isBST(root.right);
		
		boolean res = left.max < root.data && right.min > root.data; 
		
		BSTPair mPair = new BSTPair();
		mPair.min = Math.min(root.data, Math.min(left.min,right.min));
		mPair.max = Math.max(root.data, Math.max(left.max,right.max));
		mPair.isBST = res && left.isBST && right.isBST;
		
		return mPair;
		
	}

	
	public static int max(Node node) {
		if(node == null) return Integer.MIN_VALUE;
		
		int lmax = max(node.left);
		int rmax = max(node.right);
		
		return Math.max(node.data, Math.max(lmax, rmax));
	}
	
	public static int min(Node node) {
		if(node == null) return Integer.MAX_VALUE;
		
		int lmin = min(node.left);
		int rmin = min(node.right);
		
		return Math.min(node.data, Math.min(lmin, rmin));
	}

	public static boolean isBST1(Node root) {
		//O(n2) sir
		if(root == null) return true;
		
		boolean res = true;
		int min = min(root.right);
		int max = max(root.left);
		
		res = res && (root.data > max) && (root.data < min);
		
		res = res && isBST1(root.left) && isBST1(root.right);
		
		return res;
	}

	
//	public static boolean isBST1(Node root) {
//		//O(n2) mine
//		if(root == null) return true;
//		boolean leftCheck = isBST1(root.left);
//		boolean rightCheck = isBST1(root.right);
//		
//		boolean res = leftCheck && rightCheck;
//		if(!res) {
//			return false;
//		}
//		
//		int min = min(root.right);
//		int max = max(root.left);
//		
//		res = res && (root.data > max) && (root.data < min);
//		
//		
//		return res;
//	}
	
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

		System.out.println(isBST(root).isBST);
	}

}
