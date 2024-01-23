package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class _14_Minimum_Operations_to_Make_the_Array_Increasing {

	public int minOperations(int[] nums) {
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int steps = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!q.isEmpty() && q.peek() >= nums[i]) {
				int old = nums[i];
				nums[i] = q.peek() + 1;
				steps += (nums[i] - old);
				q.poll();
			}
			q.offer(nums[i]);
		}
		return steps;
	}

}
