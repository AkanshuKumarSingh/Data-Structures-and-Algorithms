package BinaryTree;

public class _26_Binary_Tree_Maximum_Path_Sum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static int maxSum = Integer.MIN_VALUE;

	public int sum(TreeNode root) {
		if (root == null)
			return 0;
		int lsum = sum(root.left);
		int rsum = sum(root.right);
		maxSum = Math.max(
				Math.max(Math.max(Math.max(lsum + root.val, rsum + root.val), lsum + rsum + root.val), maxSum),
				root.val);
		return Math.max(Math.max(lsum + root.val, rsum + root.val), root.val);
		
//      to remove so many math.max
//		int lsum = Math.max(sum(root.left), 0);
//		int rsum = Math.max(sum(root.right), 0);
//		maxSum = Math.max(lsum + rsum + root.val, maxSum);
//		return Math.max(lsum + root.val, rsum + root.val);
		
	}

	public int maxPathSum(TreeNode root) {
		maxSum = Integer.MIN_VALUE;
		sum(root);
		return maxSum;
	}

}
