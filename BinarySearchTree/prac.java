package BinarySearchTree;

import BinarySearchTree.Construction.Node;

public class prac {
	
	public static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		Node(int data){
			this.data = data;
		}
	}
	
	public static Node construction(int arr[], int st, int hi) {
		if(st > hi) return null;
		int mid = st + (hi-st)/2;
		Node node = new Node(arr[mid]);
		node.left = construction(arr, st, mid-1);
		node.right = construction(arr, mid+1, hi);
		return node;
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
		display(root.left);
		display(root.right);
	}
	
	public static void main(String[] args) {
		int data[] = { 12, 25, 30, 37, 50, 62, 70, 75, 87 };
		Node root = construction(data,0,data.length-1);
		display(root);
	}

}
