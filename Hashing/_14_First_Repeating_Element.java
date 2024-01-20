package Hashing;

import java.util.HashMap;

public class _14_First_Repeating_Element {

	public static int firstRepeated(int[] arr, int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int idx = 10000;
		for (int i = 0; i < n; i++) {
			if (map.containsKey(arr[i])) {
				idx = Math.min(idx, map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], i);
			}
		}
		return idx == 10000 ? -1 : idx;
	}

}
