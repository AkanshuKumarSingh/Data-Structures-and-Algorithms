package Hashing;

import java.util.HashMap;

public class _25_Non_Repeating_Element {

	public int firstNonRepeating(int arr[], int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int no : arr) {
			map.put(no, map.getOrDefault(no, 0) + 1);
		}

		for (int no : arr) {
			if (map.get(no) == 1)
				return no;
		}

		return -1;
	}

}
