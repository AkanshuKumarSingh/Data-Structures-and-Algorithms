package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stock_Span_Problem {

	public static void display(int[] a) {
		StringBuilder sb = new StringBuilder();

		for (int val : a) {
			sb.append(val + "\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		int[] span = solve(a);
		display(span);
	}

	public static int[] solve(int[] arr) {
		int res[] = getIndexArr(arr);
		for(int i = 0; i < arr.length; i++) {
			res[i] = i - res[i];
		}
		return res;
	}

	public static int[] getIndexArr(int arr[]) {
		Stack<Integer> st = new Stack<>();
		st.push(arr.length - 1);
		int res[] = new int[arr.length];

		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] < arr[i]) {
				res[st.pop()] = i;
			}
			st.push(i);
		}

		while (st.size() > 0) {
			res[st.pop()] = -1;
		}
		return res;

	}
	
}