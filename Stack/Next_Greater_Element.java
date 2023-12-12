package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Next_Greater_Element {

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

		int[] nge = solve(a);
		display(nge);

		int[] nse = solve1(a);
		display(nse);

		int[] pge = solve2(a);
		display(pge);
		pge = solve5(a);
		display(pge);

		int[] pse = solve3(a);
		display(pse);

	}

	// Next Greater Element
	public static int[] solve(int[] arr) {
		Stack<Integer> st = new Stack<>();
		st.push(0);
		int res[] = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[st.peek()] < arr[i]) {
				res[st.pop()] = arr[i];
			}
			st.push(i);
		}

		while (st.size() > 0) {
			res[st.pop()] = -1;
		}
		return res;
	}

	// Next Smaller element
	public static int[] solve1(int[] arr) {
		Stack<Integer> st = new Stack<>();
		st.push(0);
		int res[] = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[st.peek()] > arr[i]) {
				res[st.pop()] = arr[i];
			}
			st.push(i);
		}

		while (st.size() > 0) {
			res[st.pop()] = -1;
		}

		return res;
	}

	// Previous Greater element
	public static int[] solve2(int arr[]) {
		Stack<Integer> st = new Stack<>();
		st.push(arr.length - 1);
		int res[] = new int[arr.length];

		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] < arr[i]) {
				res[st.pop()] = arr[i];
			}
			st.push(i);
		}

		while (st.size() > 0) {
			res[st.pop()] = -1;
		}

		return res;
	}

	// Previous Smaller element
	public static int[] solve3(int arr[]) {
		Stack<Integer> st = new Stack<>();
		st.push(arr.length - 1);
		int res[] = new int[arr.length];

		for (int i = arr.length - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] > arr[i]) {
				res[st.pop()] = arr[i];
			}
			st.push(i);
		}

		while (st.size() > 0) {
			res[st.pop()] = -1;
		}

		return res;
	}

	// Previous Greater element My Code by analyzing
	public static int[] solve5(int arr[]) {
		Stack<Integer> st = new Stack<>();
		st.push(0);
		int res[] = new int[arr.length];
		for (int i = 1; i < arr.length; i++) {
			while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
				st.pop();
			}
			if(!st.isEmpty()) {
				res[i] = arr[st.peek()];
			}else {
				res[i] = -1;
			}
			st.push(i);
		}

//		while (st.size() > 0) {
//			res[st.pop()] = -1;
//		}

		return res;
	}

}
