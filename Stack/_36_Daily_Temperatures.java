package Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class _36_Daily_Temperatures {

	// https://leetcode.com/problems/daily-temperatures/

	public static int[] dailyTemperatures(int[] temp) {
		int res[] = new int[temp.length];
		Stack<Integer> st = new Stack<>();
		st.push(0);

		for (int i = 1; i < temp.length; i++) {
			while (!st.isEmpty() && temp[st.peek()] < temp[i]) {
				res[st.pop()] = i;
			}
			st.push(i);
		}

		while (!st.isEmpty()) {
			int idx = st.pop();
			res[idx] = idx;
		}

//		System.out.println(Arrays.toString(res));
		
		for (int i = 0; i < res.length; i++) {
			res[i] = res[i] - i;
		}

		return res;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int temp[] = new int[n];
		for (int i = 0; i < n; i++) {
			temp[i] = scan.nextInt();
		}
		int res[] = dailyTemperatures(temp);
		System.out.println(Arrays.toString(res));
	}

}
