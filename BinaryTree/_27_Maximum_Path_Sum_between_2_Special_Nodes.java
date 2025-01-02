package BinaryTree;

public class _27_Maximum_Path_Sum_between_2_Special_Nodes {

	// this question is bit different from prev one as single node or one side path can't be answer
	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	public static int maxSum = Integer.MIN_VALUE;

	public int sum(Node root) {
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null)
			return root.data;
		int lsum = sum(root.left);
		int rsum = sum(root.right);
		maxSum = Math.max(lsum + rsum + root.data, maxSum);
		return Math.max(lsum + root.data, rsum + root.data);

//      to remove so many math.max
//		int lsum = Math.max(sum(root.left), 0);
//		int rsum = Math.max(sum(root.right), 0);
//		maxSum = Math.max(lsum + rsum + root.val, maxSum);
//		return Math.max(lsum + root.val, rsum + root.val);

	}

	int maxPathSum(Node root) {
		maxSum = Integer.MIN_VALUE;
		sum(root);
		return maxSum;
	}

}
