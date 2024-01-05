package Stack;

import java.util.Stack;

public class _25_Decode_the_string {

	public static String decodedString(String s) {
		// System.out.println("HHM");
		Stack<String> st = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (ch >= '0' && ch <= '9') {
				int no = 0, j = i;
				while (i < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
					i++;
				}
				no = Integer.parseInt(s.substring(j, i + 1));
				st.push("" + no);
			} else if (ch == '[') {
				st.push("" + ch);
			} else if (ch == ']') {
				String curr = "", ans = "";
				while (!st.peek().equals("[")) {
					curr = st.pop() + curr;
				}
				st.pop();
				int no = Integer.parseInt(st.pop());
				while (no-- > 0) {
					ans += curr;
				}
				st.push(ans);
			} else {
				st.push("" + ch);
			}
			i++;
		}
		if (st.size() == 1)
			return st.pop();
		String ans = "";
		while (!st.isEmpty())
			ans += st.pop();
		return ans;
	}

	public static void main(String[] args) {
		String str = "1[b]1[b]";
		System.out.println(decodedString(str));
	}

}
