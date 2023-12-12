package BinaryTree;

import java.util.Stack;

public class prac1 {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}

	}

	static int idx = 0;

	public static Node construct(Integer arr[]) {
		if (idx == arr.length) {
			return null;
		} else if (arr[idx] == null) {
			return null;
		}

		Node node = new Node(arr[idx]);
		idx++;
		node.left = construct(arr);
		idx++;
		node.right = construct(arr);		

		return node;
	}
	
	public static class Pair{
		Node node;
		int level = 1;
		Pair(Node node){
			this.node = node;
		}
	}
	
	public static Node iterativeConstruct(Integer arr[]) {
		int idx = 0;
		Node root = new Node(arr[idx]);
		Stack<Pair> st = new Stack<>();		
		st.push(new Pair(root));
		idx++;

		while(!st.isEmpty()) {
			Pair p = st.peek();
			if(p.level == 1) {
				if(arr[idx] != null) {
					Node node = new Node(arr[idx]);
					p.node.left = node;
					st.push(new Pair(node));
				}
				p.level++;
				idx++;
			}else if(p.level == 2) {
				if(arr[idx] != null) {
					Node node = new Node(arr[idx]);
					p.node.right = node;
					st.push(new Pair(node));
				}
				p.level++;		
				idx++;
			}else {
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
		str += root.left == null ? "." : root.left.data;
		str += " <- [" + root.data + "] -> ";
		str += root.right == null ? "." : root.right.data;
		System.out.println(str);
//		System.out.println(root.left + " <- " + root + " -> " + root.right);
		display(root.left);
		display(root.right);
	}

	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 3, null, null, 4, null, null, 6, 5, 
				null, null, 7, null, null};
		Node root = construct(arr);
		display(root);
	}

}
