package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class _25_Level_order_traversal_in_spiral_form {

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
	
	ArrayList<Integer> findSpiral(Node root) {
		Stack<Node> mainS = new Stack<>();
		Stack<Node> helperS = new Stack<>();

		mainS.push(root);
		ArrayList<Integer> list = new ArrayList<>();
		int ht = 0;

		while (!mainS.isEmpty()) {

			while (!mainS.isEmpty()) {
				Node curr = mainS.pop();

				list.add(curr.data);
				if (ht % 2 == 1) {
					if (curr.left != null)
						helperS.push(curr.left);
					if (curr.right != null)
						helperS.push(curr.right);
				} else {
					if (curr.right != null)
						helperS.push(curr.right);
					if (curr.left != null)
						helperS.push(curr.left);
				}
			}

			Stack<Node> t = mainS;
			mainS = helperS;
			helperS = t;

			ht++;
		}

		return list;
	}

}
