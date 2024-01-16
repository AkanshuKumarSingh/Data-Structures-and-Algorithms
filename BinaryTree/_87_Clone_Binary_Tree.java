package BinaryTree;

import java.util.HashMap;

public class _87_Clone_Binary_Tree {

	static class Tree {
		int data;
		Tree left, right, random;

		Tree(int d) {
			data = d;
			left = null;
			right = null;
			random = null;
		}
	}

	HashMap<Integer, Tree> map = new HashMap<>();

	public Tree cloneTree(Tree tree) {
		if (tree == null)
			return null;

		Tree node = new Tree(tree.data);
		map.put(tree.data, node);

		node.left = cloneTree(tree.left);
		node.right = cloneTree(tree.right);
		if (tree.random != null) {
			tree.random = node.random;
		}
		return node;

	}

}
