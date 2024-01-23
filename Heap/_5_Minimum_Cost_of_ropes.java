package Heap;

import java.util.PriorityQueue;

public class _5_Minimum_Cost_of_ropes {

	long minCost(long arr[], int n) {
		if (n == 1)
			return 0;
		PriorityQueue<Long> q = new PriorityQueue<>();
		for (long no : arr) {
			q.offer(no);
		}

		long ans = 0;
		while (q.size() > 1) {
			long no1 = q.poll();
			long no2 = q.poll();
			ans += (no1 + no2);
			q.offer(no1 + no2);
		}

		return ans;
	}

}
