package BinaryTree;

import java.util.ArrayList;

public class _61_Root_to_Leaf_Paths {

	static class Node {
		int data;
		Node left, right;

		Node(int d) {
			data = d;
			left = right = null;
		}
	}

	public ArrayList<ArrayList<Integer>> Paths(Node root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (root == null)
			return ans;
		if (root.left == null && root.right == null) {
			ArrayList<Integer> bres = new ArrayList<>();
			bres.add(root.data);
			ans.add(bres);
			return ans;
		}

		ArrayList<ArrayList<Integer>> lPaths = Paths(root.left);
		for (ArrayList<Integer> curr : lPaths) {
			curr.add(0, root.data);
			ans.add(curr);
		}

		ArrayList<ArrayList<Integer>> rPaths = Paths(root.right);
		for (ArrayList<Integer> curr : rPaths) {
			curr.add(0, root.data);
			ans.add(curr);
		}
		return ans;
	}

	// 2nd way
	ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	public void makeList(Node root, ArrayList<Integer> nos) {
		if (root == null) {
			return;
		} else if (root.left == null && root.right == null) {
			nos.add(root.data);
			list.add(new ArrayList<Integer>(nos));
			nos.remove(nos.size() - 1);
			return;
		}
		nos.add(root.data);
		makeList(root.left, nos);
		makeList(root.right, nos);
		nos.remove(nos.size() - 1);
	}

	public ArrayList<ArrayList<Integer>> Paths1(Node root) {
		// System.out.println("JMD");
		makeList(root, new ArrayList<Integer>());
		return list;
	}

}
