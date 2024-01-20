package Hashing;

import java.util.HashMap;

public class _34_Repeated_Character {

	char firstRep(String S) {
		HashMap<Character, Integer> map = new HashMap<>();
		int min = 100000;
		char ans = '#';
		for (int i = 0; i < S.length(); i++) {
			char ch = S.charAt(i);
			if (map.containsKey(ch)) {
				if (min > map.get(ch)) {
					min = map.get(ch);
					ans = ch;
				}
			} else {
				map.put(ch, i);
			}
		}
		return ans;
	}

}
