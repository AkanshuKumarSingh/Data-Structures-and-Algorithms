package BinaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

import BinaryTree._2_Size_Sum_Maximum_And_Height_Of_Binary_Tree.Node;
import BinaryTree._2_Size_Sum_Maximum_And_Height_Of_Binary_Tree.Pair;

public class _3_traversal {
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

	public static int size(Node node) {
		if(node == null) return 0;
		
		int lsize = size(node.left);
		int rsize = size(node.right);
		
		return lsize+rsize+1;
	}

	public static int sum(Node node) {
		if(node == null) return 0;
		
		int lsum = sum(node.left);
		int rsum = sum(node.right);
		
		return lsum+rsum+node.data;
	}

	public static int max(Node node) {
		if(node == null) return Integer.MIN_VALUE;
		
		int lmax = max(node.left);
		int rmax = max(node.right);
		
		return Math.max(node.data, Math.max(lmax, rmax));
	}

	public static int height(Node node) {
		if(node == null) return -1;
		
		int lheight = height(node.left);
		int rheight = height(node.right);
		
		return Math.max(lheight, rheight)+1;
	}

	public static void preOrder(Node node) {
		if(node == null) return;
		
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void inOrder(Node node) {
		if(node == null) return;
		
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public static void postOrder(Node node) {
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}
	
//    ArrayList<Integer> postOrder1(Node root)
//    {
//       if(root == null) return new ArrayList<Integer>();
//       ArrayList<Integer> ans = new ArrayList<>();
//       ans.addAll(postOrder(root.left));
//       ans.addAll(postOrder(root.right));
//       ans.add(root.data);
//       return ans;
//    }
	
//    ArrayList<Integer> preOrder1(Node root)
//    {
//      if(root == null) return new ArrayList<Integer>();
//      ArrayList<Integer> ans = new ArrayList<>();
//      ans.add(root.data);
//      
//      ArrayList<Integer> curr = preOrder(root.left);
//      for(int i : curr)
//        ans.add(i);
//        
//      curr = preOrder(root.right);
//      for(int i : curr)
//        ans.add(i);
//      
//      return ans;
//    }
//   
	
//    ArrayList<Integer> inOrder(Node root)
//    {
//        if(root == null) return new ArrayList<>();
//        ArrayList<Integer> ans = inOrder(root.left);
//        ans.add(root.data);
//        ans.addAll(inOrder(root.right));
//        return ans;
//    }
	
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

		int size = size(root);
		int sum = sum(root);
		int max = max(root);
		int ht = height(root);
		System.out.println(size);
		System.out.println(sum);
		System.out.println(max);
		System.out.println(ht);
	}

}
