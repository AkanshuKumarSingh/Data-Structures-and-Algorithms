package Heap;

import java.util.PriorityQueue;

public class _8_Kth_element_in_Matrix {

	static class Pair implements Comparable<Pair> {
		int val;
		int index;
		int listNo;

		Pair(int listNo, int index, int val) {
			this.listNo = listNo;
			this.index = index;
			this.val = val;
		}

		public int compareTo(Pair p) {
			return this.val - p.val;
		}

	}

	public static int kthSmallest(int[][] arrays, int n, int k) {
		// System.out.println("JMD");
		PriorityQueue<Pair> queue = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			queue.add(new Pair(i, 0, arrays[i][0]));
		}
		int cnt = 0;
		while (!queue.isEmpty()) {
			Pair p = queue.remove();
			cnt++;
			if (k == cnt) {
				return p.val;
			}
			p.index++;
			if (p.index < n) {
				queue.add(new Pair(p.listNo, p.index, arrays[p.listNo][p.index]));
			}
		}
		return -1;
	}

}
