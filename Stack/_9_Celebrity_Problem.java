package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9_Celebrity_Problem {

	public static void findCelebrity(int[][] arr) {
		int n = arr.length;
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			st.push(i);
		}

		while (st.size() > 1) {
			int i = st.pop();
			int j = st.pop();

			if (arr[i][j] == 1) {
				// i knows j -> i is not celebrity
				st.push(j);
			} else {
				// i don't know j -> j is not celebrity
				st.push(i);
			}
		}

		int candidate = st.pop();

		// check within row -> arr[candidate][c] must be 0 i.e candidate must not know
		// anyone
		for (int c = 0; c < n; c++) {
			if (arr[candidate][c] == 1) {
				System.out.println("none");
				return;
			}
		}

		// check within col -> arr[r][candidate] must be 1 i.e everyone must know
		// candidate
		// except itself
		for (int r = 0; r < n; r++) {
			if (r != candidate && arr[r][candidate] == 0) {
				System.out.println("none");
				return;
			}
		}

		System.out.println(candidate);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];

		for (int j = 0; j < n; j++) {
			String line = br.readLine();
			for (int k = 0; k < n; k++) {
				arr[j][k] = line.charAt(k) - '0';
			}
		}

		findCelebrity(arr);
	}

}
