package Hashing;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _16_First_non_repeating_character_in_stream {

	public String FirstNonRepeating(String str) {
		StringBuilder ans = new StringBuilder();
		Queue<Character> q = new LinkedList<>();
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!map.containsKey(ch)) {
				q.offer(ch);
				map.put(ch, 1);
				ans.append(q.peek());
			} else {
				map.put(ch, -1);
				if (q.isEmpty()) {
					ans.append("#");
				} else if (ch == q.peek()) {
					while (q.size() > 0) {
						if (map.get(q.peek()) == -1)
							q.poll();
						else
							break;
					}
					if (q.isEmpty())
						ans.append("#");
					else
						ans.append(q.peek());
				} else {
					ans.append(q.peek());
				}
			}
		}
		return ans.toString();
	}

}
