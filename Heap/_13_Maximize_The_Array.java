package Heap;

import java.util.*;

public class _13_Maximize_The_Array {

	ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {
		HashSet<Integer> set = new HashSet<>();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		ArrayList<Integer> ans = new ArrayList<>();

		for (int no : arr2) {
			if (!set.contains(no)) {
				set.add(no);
				q.offer(no);
			}
		}

		for (int no : arr1) {
			if (!set.contains(no)) {
				set.add(no);
				q.offer(no);
				if (set.size() > n) {
					int val = q.poll();
					set.remove(val);
				}
			}
		}

		for (int no : arr2) {
			if (set.contains(no)) {
				ans.add(no);
				set.remove(no);
			}
		}

		for (int no : arr1) {
			if (set.contains(no)) {
				ans.add(no);
				set.remove(no);
			}
		}

		return ans;
	}

}
