package LinkedList;

import java.util.HashMap;
import java.util.LinkedList;

public class _33_Count_Pairs_whose_sum_is_equal_to_X {

	public static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int no : head1) {
			map.put(no, map.getOrDefault(no, 0) + 1);
		}

		int cnt = 0;
		for (int no : head2) {
			int rem = x - no;
			int freq = map.getOrDefault(rem, 0);
			if (freq > 0) {
				map.put(rem, freq - 1);
				cnt++;
			}
		}

		return cnt;
	}

}
