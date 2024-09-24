package Stack;

import java.util.Stack;

public class _18_Valid_Substring {
	
	
	// Time Complexity: O(n)
	// Space Complexity: O(n)
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

	// Time Complexity: O(n)
	// Space Complexity: O(1)
	static int findMaxLen1(String str) {
		int ans = 0;
		int left = 0, right = 0;
		for(int i = 0 ; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(') {
				left++;
			}else {
				right++;
			}
			
			if(left == right) {
				ans = Math.max(ans, left*2);
			}else if(right > left) {
				left = right = 0;
			}
		}

		left = right = 0;
		for(int i = str.length()-1 ; i >= 0 ; i--) {
			char ch = str.charAt(i);
			if(ch == '(') {
				left++;
			}else {
				right++;
			}
			
			if(left == right) {
				ans = Math.max(ans, left*2);
			}else if(left > right) {
				left = right = 0;
			}
		}
		return ans;
	}
	
}
