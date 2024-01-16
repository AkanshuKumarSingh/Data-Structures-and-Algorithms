package BinaryTree;

import java.util.*;

public class _70_Node_at_distance {

	static class Pair {
	    Node node;
	    int depth;
	 
	    Pair(Node n, int d)
	    {
	        node = n;
	        depth = d;
	    }
	}
	
	static class Node {
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	}

	// 1st way
	int cnt = 0;

	void kDistantFromLeafUtil(Node root, int path[], boolean vis[], int pathLen, int k) {
		if (root == null)
			return;
		path[pathLen] = root.data;
		vis[pathLen] = false;
		pathLen++;

		if (root.left == null && root.right == null && pathLen - 1 - k >= 0 && vis[pathLen - 1 - k] == false) {
			cnt++;
			vis[pathLen - 1 - k] = true;
			return;
		}

		kDistantFromLeafUtil(root.left, path, vis, pathLen, k);
		kDistantFromLeafUtil(root.right, path, vis, pathLen, k);
	}

	int printKDistantfromLeaf(Node root, int k) {

		int path[] = new int[1000];
		boolean visited[] = new boolean[1000];
		kDistantFromLeafUtil(root, path, visited, 0, k);
		return cnt;
	}

	// 2nd way
	public static void printKDist(Node root, int k) {
		Stack<Pair> stack = new Stack<>();
		List<Integer> path = new ArrayList<>();
		List<Boolean> visited = new ArrayList<>();
		stack.push(new Pair(root, 0));

		while (!stack.isEmpty()) {
			Pair curr = stack.pop();

			if (curr.node == null) {
				continue; // Skip null nodes
			}

			path.add(curr.node.data);
			visited.add(false);

			// If the current node is a leaf node and at the
			// correct depth
			if (curr.node.left == null && curr.node.right == null) {
				int depth = path.size() - 1 - k;
				if (depth >= 0 && !visited.get(depth)) {
					System.out.print(path.get(depth) + " "); // Print the node value
					visited.set(depth, true);
				}
			}

			// Push the left and right child nodes onto the
			// stack
			stack.push(new Pair(curr.node.left, curr.depth + 1));
			stack.push(new Pair(curr.node.right, curr.depth + 1));

			// Trim the path and visited lists to the
			// current depth
			if (curr.depth + 1 < path.size()) {
				int newSize = curr.depth + 1;
				path.subList(newSize, path.size()).clear();
				visited.subList(newSize, visited.size()).clear();
			}
		}
	}

}
