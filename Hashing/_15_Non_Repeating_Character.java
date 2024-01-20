package Hashing;

import java.util.HashMap;

public class _15_Non_Repeating_Character {

	static char nonrepeatingCharacter(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int freq = map.get(ch);
			if (freq == 1)
				return ch;
		}

		return '$';
	}

}
