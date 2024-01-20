package Hashing;

import java.util.HashMap;

public class _21_Zero_Sum_Subarrays {

	public static long findSubarray(long[] arr, int n) {
		// System.out.println("HHM");
		int cnt = 0;
		long s = 0;
		HashMap<Long, Integer> map = new HashMap<>();
		for (long i : arr) {
			s += i;
			if (s == 0) {
				cnt++;
			}
			if (map.containsKey(s)) {
				cnt += map.get(s);
			}
			map.put(s, map.getOrDefault(s, 0) + 1);
		}
		return cnt;
	}

}
