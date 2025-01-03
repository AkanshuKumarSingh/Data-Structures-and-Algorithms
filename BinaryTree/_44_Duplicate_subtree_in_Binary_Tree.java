package BinaryTree;

import java.util.HashSet;

public class _44_Duplicate_subtree_in_Binary_Tree {

	static class Node {
		char data;
		Node left, right;

		Node(char data) {
			this.data = data;
		}
	}

	static char MARKER = '$';

	// This function returns empty string if tree
	// contains a duplicate subtree of size 2 or more.
	public static String dupSubUtil(Node root, HashSet<String> subtrees) {
		String s = "";

		// If current node is NULL, return marker
		if (root == null)
			return s + MARKER;

		// If left subtree has a duplicate subtree.
		String lStr = dupSubUtil(root.left, subtrees);
		if (lStr.equals(s))
			return s;

		// Do same for right subtree
		String rStr = dupSubUtil(root.right, subtrees);
		if (rStr.equals(s))
			return s;

		// Serialize current subtree
		// Append random char in between the value to differentiate from 11,1 and 1,11
		s = s + root.data + "%" + lStr + "%" + rStr;
		System.out.println(s);
		// If current subtree already exists in hash
		// table. [Note that size of a serialized tree
		// with single node is 7 (3+4 accounting for special chars appended)
		// as it has two marker
		// nodes.
		if (s.length() > 7 && subtrees.contains(s))
			return "";

		subtrees.add(s);
		return s;
	}

	// Function to find if the Binary Tree contains duplicate
	// subtrees of size 2 or more
	public static String dupSub(Node root) {
		HashSet<String> subtrees = new HashSet<>();
		String ans = dupSubUtil(root, subtrees);
		System.out.println(subtrees);
		return ans;
	}

	public static void main(String args[]) {
		Node root = new Node('A');
		root.left = new Node('B');
		root.right = new Node('C');
//		root.left.left = new Node('D');
//		root.left.right = new Node('E');
//		root.right.right = new Node('B');
//		root.right.right.right = new Node('E');
//		root.right.right.left = new Node('D');
		String str = dupSub(root);
		if (str.equals(""))
			System.out.print(" Yes ");
		else
			System.out.print(" No ");
		System.out.println();
	}

}
