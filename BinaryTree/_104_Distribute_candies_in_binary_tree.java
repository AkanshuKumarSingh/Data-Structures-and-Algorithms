package BinaryTree;

public class _104_Distribute_candies_in_binary_tree {

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

	static int step;

	public static int distributeCandy(Node root) {
		step = 0;
		findMove(root);
		return step;
	}

	static int findMove(Node curnode) {
		if (curnode == null)
			return 0;

		int l = findMove(curnode.left);
		int r = findMove(curnode.right);
		step += Math.abs(l) + Math.abs(r);

		return (l + r + curnode.data - 1);
	}

}
