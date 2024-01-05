package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class _7_Sliding_Window_Maximum {
	public static int[] ngrIndex(int arr[]) {
		Stack<Integer> st = new Stack<>();
		st.push(0);
		int res[] = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {
			while (st.size() > 0 && arr[st.peek()] < arr[i]) {
				res[st.pop()] = i;
			}
			st.push(i);
		}

		while (st.size() > 0) {
			res[st.pop()] = arr.length;
		}
		return res;
	}

	public static void findMaxInEachWindow(int arr[], int k) {
		int ngri[] = ngrIndex(arr);
		int j = 0;

		for (int i = 0; i <= arr.length - k; i++) {
			if (j < i) {
				j = i;
			}

			while (i + k > ngri[j]) {
				j = ngri[j];
			}
			System.out.println(arr[j]);
		}

	}

	// GFG
	static int[] ngi(int arr[], int n) {
		Stack<Integer> st = new Stack<>();
		int res[] = new int[n];
		st.push(0);

		for (int i = 1; i < n; i++) {
			while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
				res[st.pop()] = i;
			}
			st.push(i);
		}

		while (!st.isEmpty()) {
			res[st.pop()] = n;
		}

		return res;
	}

	static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		int ngi[] = ngi(arr, n);
		int j = 0;
		for (int i = 0; i <= n - k; i++) {
			if (j < i)
				j = i;
			while (ngi[j] < i + k) {
				j = ngi[j];
			}
			ans.add(arr[j]);
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		int k = Integer.parseInt(br.readLine());
		findMaxInEachWindow(a, k);
	}
}
