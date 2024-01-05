package Stack;

import java.util.Stack;

public class _23_Reverse_each_word_in_given_string {

	String reverseWords(String str) {
		String ans = "", curr = "";
		Stack<Character> st = new Stack<>();

		for (char ch : str.toCharArray()) {
			st.push(ch);
		}

		while (!st.isEmpty()) {
			char ch = st.pop();
			if (ch == '.') {
				ans = ch + curr + ans;
				curr = "";
			} else {
				curr += ch;
			}
		}
		ans = curr + ans;
		return ans;
	}

}
