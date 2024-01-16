package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _18_Left_View_of_Binary_Tree {

	static class Node
	{
	    int data;
	    Node left, right;

	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	
	ArrayList<Integer> leftView(Node root) {
		if (root == null)
			return new ArrayList<Integer>();
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		ArrayList<Integer> ans = new ArrayList<>();

		while (!q.isEmpty()) {
			int sz = q.size();
			boolean flag = true;
			while (sz-- > 0) {
				Node node = q.poll();
				if (flag)
					ans.add(node.data);

				flag = false;
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
			}

		}

		return ans;
	}

}
