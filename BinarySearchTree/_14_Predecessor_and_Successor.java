package BinarySearchTree;

public class _14_Predecessor_and_Successor {

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

	static Node pre, suc;

	public static void findPreSuc(Node root, int key) {
		// code here.

		/*
		 * There are two static nodes defined above pre(representing predecessor) and
		 * suc(representing successor) as follows: static Node pre=null,suc=null You
		 * need to update these both. And the data inside these classes will be printed
		 * automatically by the driver code.
		 */

		if (root == null)
			return;
		findPreSuc(root.left, key);
		if (root.data < key) {
			if (pre == null || pre.data < root.data) {
				pre = root;
			}
		} else if (root.data > key) {
			if (suc == null || suc.data > root.data) {
				suc = root;
			}
		}
		findPreSuc(root.right, key);
	}

}
