package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class _28_Print_Bracket_Number {

	static class Node {
		char ch;
		int no;

		Node(char ch, int no) {
			this.ch = ch;
			this.no = no;
		}
	}

	ArrayList<Integer> bracketNumbers(String str) {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<Node> st = new Stack<>();
		int no = 1;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				st.push(new Node(ch, no));
				ans.add(no);
				no++;
			} else if (ch == ')') {
				ans.add(st.peek().no);
				st.pop();
			}
		}

		return ans;
	}

}
