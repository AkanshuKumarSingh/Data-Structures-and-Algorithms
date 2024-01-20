package Hashing;

import java.util.*;

public class _36_Print_Anagrams_Together {

	public List<List<String>> Anagrams(String[] string_list) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : string_list) {
			char ch[] = str.toCharArray();
			Arrays.sort(ch);
			String newStr = new String(ch);
			if (!map.containsKey(newStr)) {
				List<String> l = new ArrayList<String>();
				l.add(str);
				map.put(newStr, l);
			} else {
				map.get(newStr).add(str);
			}
		}
		return new ArrayList<>(map.values());
	}

}
