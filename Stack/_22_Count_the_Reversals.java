package Stack;

import java.util.Stack;

public class _22_Count_the_Reversals {

	int countRev(String str) {
		if (str.length() % 2 == 1)
			return -1;

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '{') {
				st.push(ch);
			} else {
				if (!st.isEmpty() && st.peek() == '{') {
					st.pop();
				} else {
					st.push('}');
				}
			}
		}

		int sz = st.size(), m = 0;
		while (!st.isEmpty() && st.peek() == '{') {
			m++;
			st.pop();
		}
		return (int) (Math.ceil((float) m / 2) + Math.ceil((float) (sz - m) / 2));
	}

}
