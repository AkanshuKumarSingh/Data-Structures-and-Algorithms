package Stack;

import java.util.Stack;

public class _26_Restrictive_Candy_Crush {

	public static class Node {
		char ch;
		int freq;

		Node(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}
	}

	public static String reduced_String(int k, String s) {
		if (k == 1)
			return "";
		StringBuffer ans = new StringBuffer();
		Stack<Node> st = new Stack<>();
		st.push(new Node(s.charAt(0), 1));

		for (int i = 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (st.isEmpty()) {
				st.push(new Node(ch, 1));
				continue;
			}

			Node node = st.peek();
			if (ch == st.peek().ch) {
				if (k - 1 == node.freq) {
					st.pop();
				} else {
					node.freq++;
				}
			} else {
				st.push(new Node(ch, 1));
			}
		}

		while (!st.isEmpty()) {
			Node node = st.pop();
			StringBuffer curr = new StringBuffer("");
			while (node.freq-- > 0) {
				curr.insert(0, node.ch);
			}
			ans.insert(0, curr);
		}
		return ans.toString();
	}

}
