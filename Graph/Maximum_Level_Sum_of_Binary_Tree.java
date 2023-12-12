package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Level_Sum_of_Binary_Tree {
	
//	https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

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

	public int maxLevelSum(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int max = Integer.MIN_VALUE;
		int level = 0;
		int currLevel = 1;

		while (!q.isEmpty()) {
			int sz = q.size();
			int sum = 0;
			while (sz-- > 0) {
				TreeNode node = q.poll();
				sum += node.val;
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
			}
			if (max < sum) {
				max = sum;
				level = currLevel;
			}
			currLevel++;
		}
		return level;

	}

	public static void main(String[] args) {

	}

}
