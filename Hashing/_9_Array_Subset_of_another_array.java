package Hashing;

import java.util.HashMap;

public class _9_Array_Subset_of_another_array {

	public String isSubset(long a1[], long a2[], long n, long m) {
		HashMap<Long, Integer> map = new HashMap<>();
		for (long no : a1) {
			map.put(no, map.getOrDefault(no, 0) + 1);
		}

		for (long no : a2) {
			int freq = map.getOrDefault(no, 0);
			if (freq == 0)
				return "No";
			else if (freq - 1 == 0)
				map.remove(no);
			else
				map.put(no, freq - 1);
		}

		return "Yes";
	}

}
