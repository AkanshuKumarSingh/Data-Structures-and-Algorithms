package Stack;

import java.util.Stack;

public class _20_Longest_valid_Parentheses {

	static int maxLength(String str) {
		int ans = 0;
		Stack<Integer> st = new Stack<>();
		st.push(-1);

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				st.push(i);
			} else {
				if (!st.isEmpty()) {
					st.pop();
				}

				if (!st.isEmpty()) {
					ans = Math.max(ans, i - st.peek());
				} else {
					st.push(i);
				}
			}
		}
		return ans;
	}

}
