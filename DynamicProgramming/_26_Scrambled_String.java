package DynamicProgramming;

import java.util.HashMap;

public class _26_Scrambled_String {

	static boolean scrambleStringsRecursive(String s1, String s2) {
		if (s1.equals(s2)) {
			return true;
		}

		if (s1.length() <= 1) {
			return false;
		}

		int n = s1.length();
		boolean flag = false;
		for (int i = 1; i < n; i++) {
			if ((scrambleStringsRecursive(s1.substring(0, i), s2.substring(n - i, n))
					&& scrambleStringsRecursive(s1.substring(i, n), s2.substring(0, n - i)))
					|| (scrambleStringsRecursive(s1.substring(0, i), s2.substring(0, i))
							&& scrambleStringsRecursive(s1.substring(i, n), s2.substring(i, n)))) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	static HashMap<String, Boolean> map = new HashMap<>();
	static boolean scrambleStringsMemoization(String s1, String s2) {
		if (s1.equals(s2)) {
			return true;
		}

		if (s1.length() <= 1) {
			return false;
		}
		
		String key = s1 + " " + s2;
		if(map.containsKey(key)) {
			return map.get(key);
		}

		int n = s1.length();
		boolean flag = false;
		for (int i = 1; i < n; i++) {
			if ((scrambleStringsMemoization(s1.substring(0, i), s2.substring(n - i, n))
					&& scrambleStringsMemoization(s1.substring(i, n), s2.substring(0, n - i)))
					|| (scrambleStringsMemoization(s1.substring(0, i), s2.substring(0, i))
							&& scrambleStringsMemoization(s1.substring(i, n), s2.substring(i, n)))) {
				flag = true;
				break;
			}
		}
		
		map.put(key, flag);
		return flag;
	}
	
	static boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (s1.length() == 0)
			return true;
		map.clear();
		return scrambleStringsMemoization(s1, s2);
	}

}
