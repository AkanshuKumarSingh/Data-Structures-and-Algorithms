package Hashing;

import java.util.HashMap;

public class _7_Check_if_two_arrays_are_equal_or_not {

	public static boolean check(long A[], long B[], int N) {
		HashMap<Long, Integer> map = new HashMap<>();
		for (long no : A) {
			map.put(no, map.getOrDefault(no, 0) + 1);
		}

		for (long no : B) {
			if (!map.containsKey(no))
				return false;
			int freq = map.get(no);
			if (freq - 1 == 0)
				map.remove(no);
			else
				map.put(no, freq - 1);
		}

		return map.size() == 0;
	}

}
