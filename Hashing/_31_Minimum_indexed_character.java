package Hashing;

import java.util.HashMap;

public class _31_Minimum_indexed_character {

	public static int minIndexChar(String str, String patt) {
		int min = 100000;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!map.containsKey(ch))
				map.put(ch, i);
		}

		for (int i = 0; i < patt.length(); i++) {
			char ch = patt.charAt(i);
			min = Math.min(min, map.getOrDefault(ch, 100000));
		}

		return min == 100000 ? -1 : min;
	}

}
