package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _10_First_negative_integer_in_every_window_of_size_k {

	// Using stack O(n) space and time
	static public long[] printFirstNegativeInteger(long arr[], int n, int k) {

		int ni[] = new int[n];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && arr[i] < 0) {
				ni[st.pop()] = i;
			}

			if (arr[i] < 0) {
				ni[i] = i;
			} else {
				st.push(i);
			}

		}
		while (!st.isEmpty()) {
			ni[st.pop()] = n;
		}

		long ans[] = new long[n - k + 1];
		int j = 0;
		for (int i = 0; i <= n - k; i++) {
			if (ni[i] - i < k)
				ans[i] = arr[ni[i]];
		}
		return ans;

	}

	// Using stack O(k) space and O(n)time
	static public long[] printFirstNegativeInteger1(long arr[], int n, int k) {

		Queue<Integer> q = new LinkedList<>();
		long ans[] = new long[n - k + 1];
		int i;
		for (i = 0; i < k; i++) {
			if (arr[i] < 0)
				q.offer(i);
		}

		for (; i < n; i++) {
			if (q.isEmpty()) {
				ans[i - k] = 0;
			} else {
				ans[i - k] = arr[q.peek()];
				while (!q.isEmpty() && i - q.peek() >= k) {
					q.poll();
				}
			}

			if (arr[i] < 0)
				q.offer(i);
		}

		if (q.isEmpty()) {
			ans[i - k] = 0;
		} else {
			ans[i - k] = arr[q.peek()];
		}

		return ans;

	}

	public long[] printFirstNegativeInteger3(long arr[], int n, int k) {
		int negIdx = 0;
		long ans[] = new long[n - k + 1];
		for (int i = k - 1; i < n; i++) {
			while (negIdx + k <= i || (arr[negIdx] >= 0 && negIdx < i)) {
				negIdx++;
			}

			if (arr[negIdx] < 0) {
				ans[i - k + 1] = arr[negIdx];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long arr[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		long ans[] = printFirstNegativeInteger(arr, arr.length, 3);
		System.out.println();
		for (long i : ans) {
			System.out.print(i + " ");
		}
	}

}
