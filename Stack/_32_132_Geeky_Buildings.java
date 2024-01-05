package Stack;

import java.util.Stack;

public class _32_132_Geeky_Buildings {

	static boolean recreationalSpot(int[] arr, int n) {
		Stack<Integer> st = new Stack<>();
		int third = Integer.MIN_VALUE;

		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] < third)
				return true;
			while (!st.isEmpty() && arr[i] > st.peek()) {
				third = st.pop();
			}
			st.push(arr[i]);
		}
		return false;
	}

}
