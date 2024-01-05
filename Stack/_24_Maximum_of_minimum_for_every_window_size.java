package Stack;

import java.util.Stack;

public class _24_Maximum_of_minimum_for_every_window_size {

	static int[] maxOfMin(int[] arr, int n) {
		int nse[] = new int[n];
		int pse[] = new int[n];
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
				nse[st.pop()] = i;
			}
			st.push(i);
		}

		while (!st.isEmpty()) {
			nse[st.pop()] = n;
		}

		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
				pse[st.pop()] = i;
			}
			st.push(i);
		}

		while (!st.isEmpty()) {
			pse[st.pop()] = -1;
		}

		int res[] = new int[n];
		for (int i = 0; i < n; i++) {
			int idx = nse[i] - pse[i] - 2;
			res[idx] = Math.max(arr[i], res[idx]);
		}

		for (int i = n - 2; i >= 0; i--) {
			res[i] = Math.max(res[i], res[i + 1]);
		}

		return res;
	}

}
