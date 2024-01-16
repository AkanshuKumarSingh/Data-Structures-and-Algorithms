package BinaryTree;

import java.util.*;

public class _94_Select_Nodes {

	static class Node {
		int data;
		ArrayList<Node> neighs;

		Node(int data) {
			this.data = data;
			neighs = new ArrayList<>();
		}
	}

	int cnt = 0;

	public boolean dfs(Node root, HashSet<Integer> vis) {

		boolean isSelected = false;
		vis.add(root.data);

		for (Node neigh : root.neighs) {
			if (!vis.contains(neigh.data)) {
				boolean select = dfs(neigh, vis);
				if (!select) {
					isSelected = true;
				}
			}
		}

		if (isSelected) {
			cnt++;
		}

		return isSelected;
	}

	public int countVertex(int N, int[][] edges) {
		HashMap<Integer, Node> map = new HashMap<>();
		HashSet<Integer> vis = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			map.put(i, new Node(i));
		}

		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			Node n = map.get(u), m = map.get(v);
			n.neighs.add(m);
			m.neighs.add(n);
		}

		dfs(map.get(1), vis);
		return cnt;
	}

}
