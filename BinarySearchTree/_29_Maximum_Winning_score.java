package BinarySearchTree;

public class _29_Maximum_Winning_score {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static Long findMaxScore(Node root) {
		if (root == null)
			return (long) 1;
		long product1 = root.data, product2 = root.data;
		product1 = product1 * findMaxScore(root.right);
		product2 = product2 * findMaxScore(root.left);
		return Math.max(product1, product2);
	}

}
