package Graph;

import java.util.*;

public class _54_Burning_Tree {

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
    
	public static int minTime(Node root, int target) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		HashMap<Node, Node> map = new HashMap<>();
		Node tar = null;

		while (!q.isEmpty()) {
			Node curr = q.remove();
			if (curr.data == target)
				tar = curr;

			if (curr.left != null) {
				map.put(curr.left, curr);
				q.add(curr.left);
			}
			if (curr.right != null) {
				map.put(curr.right, curr);
				q.add(curr.right);
			}
		}

		int time = 0;
		q.offer(tar);
		boolean flag = false;
		HashSet<Integer> set = new HashSet<>();
		set.add(target);

		while (!q.isEmpty()) {
			int sz = q.size();
			while (sz-- > 0) {
				Node curr = q.poll();

				if (curr.left != null && !set.contains(curr.left.data)) {
					flag = true;
					q.add(curr.left);
					set.add(curr.left.data);
				}
				if (curr.right != null && !set.contains(curr.right.data)) {
					flag = true;
					q.add(curr.right);
					set.add(curr.right.data);
				}
				if (map.get(curr) != null && !set.contains(map.get(curr).data)) {
					flag = true;
					q.add(map.get(curr));
					set.add(map.get(curr).data);
				}
			}
			if (flag)
				time++;
			flag = false;
		}

		return time;
	}

}
