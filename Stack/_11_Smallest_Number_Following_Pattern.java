package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _11_Smallest_Number_Following_Pattern {

	public static void smallestNumberFollowingPattern(String pattern) {
		Stack<Integer> st = new Stack<>();
		int count = 1;

		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if (ch == 'd') {
				st.push(count);
				count++;
			} else {
				st.push(count);
				count++;
				while (st.size() > 0) {
					System.out.print(st.pop());
				}
			}
		}
		st.push(count);

		while (st.size() > 0) {
			System.out.print(st.pop());
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		smallestNumberFollowingPattern(str);
	}

}
