package BinarySearchTree;

public class _1_Construction {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public static Node construction(int arr[], int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		Node node = new Node(arr[mid]);
		node.left = construction(arr, start, mid - 1);
		node.right = construction(arr, mid + 1, end);
		return node;
	}

	public static void display(Node root) {
		if (root == null) {
			return;
		}
		String str = "";
		str += root.left == null ? "." : root.left.data;
		str += " <- [" + root.data + "] -> ";
		str += root.right == null ? "." : root.right.data;
		System.out.println(str);
//		System.out.println(root.left + " <- " + root + " -> " + root.right);
		display(root.left);
		display(root.right);
	}

	public static void main(String[] args) {
		int data[] = { 12, 25, 30, 37, 50, 62, 70, 75, 87 };
		Node root = construction(data,0,data.length-1);
		display(root);
	}

}
