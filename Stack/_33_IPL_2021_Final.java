package Stack;

import java.util.Stack;

public class _33_IPL_2021_Final {

	static int findMaxLen(String str) {
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
