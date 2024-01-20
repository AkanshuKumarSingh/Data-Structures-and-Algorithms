package Hashing;

import java.util.HashMap;

public class _20_Array_Pair_Sum_Divisibility_Problem {

	public boolean canPair(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int rem = -1;
			if (nums[i] < 0) {
				rem = (nums[i] % k) + k;
			} else {
				rem = nums[i] % k;
			}

			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}

		for (int i = 0; i < nums.length; i++) {
			int rem = -1;
			if (nums[i] < 0) {
				rem = (nums[i] % k) + k;
			} else {
				rem = nums[i] % k;
			}

			if (rem == 0) {
				if (map.get(0) % 2 != 0)
					return false;
			} else if (2 * rem == k) {
				if (map.get(rem) % 2 != 0)
					return false;
			} else {
				if (map.get(rem) != map.getOrDefault(k - rem, 0))
					return false;
			}
		}
		return true;
	}

}
