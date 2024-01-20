package Hashing;

import java.util.HashMap;

public class _30_Largest_subarray_of_0s_and_1s {

	int maxLen(int[] arr, int N) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0, ans = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i] == 0 ? -1 : 1;
			if (sum == 0)
				ans = i + 1;
			if (map.containsKey(sum)) {
				ans = Math.max(ans, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}
		return ans;
	}

}
