package BinaryTree;

public class _40_Count_Leaves_in_Binary_Tree {

	static class Node {
		int data;
		Node left, right;
	}

	int countLeaves(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		int leftNo = countLeaves(node.left);
		int rightNo = countLeaves(node.right);
		return leftNo + rightNo;
	}

}
