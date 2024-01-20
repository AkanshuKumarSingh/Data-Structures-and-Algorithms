package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class _37_Find_missing_in_second_array {

	ArrayList<Long> findMissing(long A[], long B[], int N, int M) {
		HashMap<Long, Integer> map = new HashMap<>();
		for (long i : A) {
			map.put(i, 1);
		}

		for (long i : B) {
			if (map.containsKey(i)) {
				map.put(i, -1);
			}
		}

		ArrayList<Long> ans = new ArrayList<>();
		for (long i : A) {
			if (map.get(i) == 1)
				ans.add(i);
		}
		return ans;
	}

}
