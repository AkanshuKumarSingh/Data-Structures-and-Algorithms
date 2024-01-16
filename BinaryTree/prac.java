package BinaryTree;

import java.util.Stack;

import BinaryTree._1_binaryTree.Node;

public class prac {
	
	public static class Node{
		int data;
		Node left;
		Node  right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static class Pair{
		int state = -1;
		Node node;
		Pair(Node node){
			this.node = node;
		}
	}
	
	static int index = 0;
	public static Node constructRecursive(Integer[] data) {
		if(data[index] == null) {
			return null;
		}
		Node node = new Node(data[index]);
		index++;
		
		node.left = constructRecursive(data);
		index++;
		
		node.right = constructRecursive(data);
		
		return node;
	}
	
	public static Node constructIterative(Integer data[]){
		int index = 1;
		Stack<Pair> st = new Stack<>();
		Node root = new Node(data[index-1]);
		st.push(new Pair(root));
		
		while(!st.isEmpty()) {
			Pair p = st.peek();
			if(p.state == -1) {
				if(data[index] != null) {
					Node newNode = new Node(data[index]);
					p.node.left = newNode;
					st.push(new Pair(newNode));
				}
				index++;
				p.state++;
			}else if(p.state == 0) {
				if(data[index] != null) {
					Node newNode = new Node(data[index]);
					p.node.right = newNode;
					st.push(new Pair(newNode));
				}
				index++;
				p.state++;
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
		str += root.left == null?".":root.left.data;
		str += " <- [" + root.data + "] -> ";
		str += root.right == null?".":root.right.data;
		System.out.println(str);
//		System.out.println(root.left + " <- " + root + " -> " + root.right);
		display(root.left);
		display(root.right);
	}
	
	public static void preOrder(Node root) {
		if(root == null) return;
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(Node root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	public static void postOrder(Node root) {
		if(root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}
	
	public static void main(String[] args) {
		System.out.println("HHM");
		int n = 2;
		while(--n > 0) {
			System.out.println(n);
		}
		
		Integer data[] = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
		null };
		Node root = constructRecursive(data);
		root = constructIterative(data);
//		display(root);
		System.out.println("PreOrder");
		preOrder(root);
		
		System.out.println("InOrder");
		inOrder(root);
		
		System.out.println("PostOrder");
		postOrder(root);
	}

}
