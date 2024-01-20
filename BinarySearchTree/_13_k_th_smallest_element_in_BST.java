package BinarySearchTree;

public class _13_k_th_smallest_element_in_BST {

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

	int cnt = 0;

	public int KthSmallestElement(Node root, int K) {
		if (root == null)
			return -1;
		int no = KthSmallestElement(root.left, K);
		if (no != -1)
			return no;
		cnt++;
		if (cnt == K)
			return root.data;
		return KthSmallestElement(root.right, K);

	}

}
