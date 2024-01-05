package Stack;

import java.util.Stack;

public class _31_Next_Greater_Element {

	public static long[] nextLargerElement(long[] arr, int n) {
		long ans[] = new long[n];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
				ans[st.pop()] = arr[i];
			}
			st.push(i);
		}
		while (!st.isEmpty())
			ans[st.pop()] = -1;
		return ans;
	}

}
