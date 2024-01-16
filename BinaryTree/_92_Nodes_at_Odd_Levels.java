package BinaryTree;

import java.util.ArrayList;

public class _92_Nodes_at_Odd_Levels {

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}
	}

	public void preOrder(Node root, ArrayList<Node> ans, int lvl) {
		if (root == null)
			return;
		if (lvl % 2 == 1)
			ans.add(root);

		preOrder(root.left, ans, lvl + 1);
		preOrder(root.right, ans, lvl + 1);

	}

	public ArrayList<Node> nodesAtOddLevels(Node root) {
		ArrayList<Node> ans = new ArrayList<>();
		preOrder(root, ans, 1);
		return ans;
	}

}
