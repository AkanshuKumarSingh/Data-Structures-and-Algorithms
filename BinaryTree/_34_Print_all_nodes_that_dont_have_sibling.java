package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class _34_Print_all_nodes_that_dont_have_sibling {
	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	void findSiblings(Node node, TreeSet<Integer> ans) {
		if (node == null)
			return;
		else if (node.left == null && node.right != null) {
			ans.add(node.right.data);
			findSiblings(node.right, ans);
		} else if (node.left != null && node.right == null) {
			ans.add(node.left.data);
			findSiblings(node.left, ans);
		} else if (node.left != null && node.right != null) {
			findSiblings(node.left, ans);
			findSiblings(node.right, ans);
		}

	}

	ArrayList<Integer> noSibling1(Node node) {
		TreeSet<Integer> set = new TreeSet<>();
		findSiblings(node, set);
		if (set.size() == 0)
			set.add(-1);
		ArrayList<Integer> ans = new ArrayList<>(set);
		return ans;
	}

	ArrayList<Integer> noSiblingHelper(Node node) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (node == null)
			return ans;
		if (node.left == null && node.right != null)
			ans.add(node.right.data);
		if (node.right == null && node.left != null)
			ans.add(node.left.data);

		ArrayList<Integer> left = noSiblingHelper(node.left);
		ArrayList<Integer> right = noSiblingHelper(node.right);
		ans.addAll(left);
		ans.addAll(right);
		return ans;
	}

	ArrayList<Integer> noSibling(Node node) {
		ArrayList<Integer> ans = noSiblingHelper(node);
		if (ans.size() == 0)
			ans.add(-1);
		Collections.sort(ans);
		return ans;
	}

}
