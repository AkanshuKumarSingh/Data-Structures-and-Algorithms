package Stack;

import java.util.Stack;

public class _29_Nearest_smaller_tower {

	int[] nearestSmallestTower(int[] arr) {
		int n = arr.length;
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

		int ans[] = new int[n];
		for (int i = 0; i < n; i++) {
			int next = nse[i], prev = pse[i];
			if (next != n && prev != -1) {
				if (i - prev < next - i) {
					ans[i] = prev;
				} else if (i - prev == next - i) {
					if (arr[prev] <= arr[next]) {
						ans[i] = prev;
					} else {
						ans[i] = next;
					}
				} else {
					ans[i] = next;
				}
			} else if (next == n && prev == -1) {
				ans[i] = prev;
			} else if (next == n) {
				ans[i] = prev;
			} else {
				ans[i] = next;
			}
		}
		return ans;
	}

}
