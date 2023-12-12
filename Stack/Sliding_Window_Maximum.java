package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sliding_Window_Maximum {
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
