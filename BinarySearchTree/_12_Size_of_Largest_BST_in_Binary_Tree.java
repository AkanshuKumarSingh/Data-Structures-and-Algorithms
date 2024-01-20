package BinarySearchTree;

public class _12_Size_of_Largest_BST_in_Binary_Tree {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode() {
	         this.data = 0;
	         this.left = null;
	         this.right = null;
	     }

		TreeNode(int data) {
	         this.data = data;
	         this.left = null;
	         this.right = null;
	     }

		TreeNode(int data, TreeNode left, TreeNode right) {
	         this.data = data;
	         this.left = left;
	         this.right = right;
	     }
	}

	static class BSTNode {
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, size = 0, node = -1;
		boolean isBST = true;

		BSTNode() {
		}

		BSTNode(int max, int min, int size, boolean isBST, int node) {
			this.max = max;
			this.min = min;
			this.size = size;
			this.isBST = isBST;
			this.node = node;
		}

	}

	static BSTNode ans = null;

	static BSTNode findNode(TreeNode root) {
		if (root == null)
			return new BSTNode();
		BSTNode left = findNode(root.left);
		BSTNode right = findNode(root.right);
		BSTNode node = new BSTNode(Math.max(right.max, root.data), Math.min(left.min, root.data),
				left.size + right.size + 1, left.isBST && right.isBST && left.max < root.data && right.min > root.data,
				root.data);
		if (node.isBST && (ans == null || ans.size < node.size)) {
			ans = node;
		}
		return node;
	}

	public static int largestBST(TreeNode root) {
		findNode(root);
		return ans.size;
	}

}
