package DynamicProgramming;

import java.util.Stack;

public class _61_Maximal_Rectangle {

	public int fxn(int arr[]) {
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		int ans = 0;
		for (int i = 0; i <= n; i++) {
			while (!st.isEmpty() && (i == n || arr[st.peek()] >= arr[i])) {
				int ht = arr[st.pop()];
				int width = -1;
				if (st.isEmpty()) {
					width = i;
				} else {
					width = i - st.peek() - 1;
				}
				ans = Math.max(ans, ht * width);
			}
			st.push(i);
		}
		return ans;
	}

	public int maximalRectangle(char[][] matrix) {
		int n = matrix[0].length, max = 0;
		int arr[] = new int[n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					arr[j]++;
				} else {
					arr[j] = 0;
				}
			}
			max = Math.max(max, fxn(arr));
		}
		return max;
	}

}
