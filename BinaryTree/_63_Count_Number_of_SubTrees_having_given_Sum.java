package BinaryTree;

public class _63_Count_Number_of_SubTrees_having_given_Sum {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	static int cnt = 0;

	int sum(Node root, int sum) {
		if (root == null)
			return 0;
		int l = sum(root.left, sum);
		int r = sum(root.right, sum);
		int data = l + r + root.data;
		if (data == sum)
			cnt++;
		return data;

	}

	// Function to count number of subtrees having sum equal to given sum.
	int countSubtreesWithSumX(Node root, int X) {
		cnt = 0;
		sum(root, X);
		return cnt;
	}

}
