package Hashing;

import java.util.*;

public class _29_Winner_of_an_election {

	public static String[] winner(String arr[], int n) {
		// System.out.println("JMD");
		int max = 0;
		ArrayList<String> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : arr) {
			map.put(str, map.getOrDefault(str, 0) + 1);
			max = Math.max(max, map.get(str));
		}

		for (Map.Entry<String, Integer> e : map.entrySet()) {
			if (e.getValue() == max) {
				list.add(e.getKey());
			}
		}

		Collections.sort(list);

		return new String[] { list.get(0), "" + max };
	}

}
