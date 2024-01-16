package BinaryTree;

public class _80_Level_of_Node_in_Binary_Tree {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	int getLevel(Node node, int data) {
		if (node == null)
			return 0;
		if (node.data == data)
			return 1;
		int lvl = getLevel(node.left, data);
		if (lvl != 0)
			return lvl + 1;
		lvl = getLevel(node.right, data);
		if (lvl != 0)
			return lvl + 1;
		return 0;
	}

}
