package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _9_Nearly_sorted {

	ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int j = 0; j < k; j++) {
			q.offer(arr[j]);
		}

		while (!q.isEmpty()) {
			if (k < arr.length)
				q.offer(arr[k]);
			ans.add(q.poll());
			k++;
		}

		return ans;
	}

}
