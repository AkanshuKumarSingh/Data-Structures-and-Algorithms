package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_To_Queue_Adapter_Add_Efficient {

	public static class StackToQueueAdapter {
		Stack<Integer> mainS;
		Stack<Integer> helperS;

		public StackToQueueAdapter() {
			mainS = new Stack<>();
			helperS = new Stack<>();
		}

		int size() {
			// write your code here
		}

		void add(int val) {
			// write your code here
		}

		int remove() {
			// write your code here
		}

		int peek() {
			// write your code here
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StackToQueueAdapter qu = new StackToQueueAdapter();

		String str = br.readLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("add")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				qu.add(val);
			} else if (str.startsWith("remove")) {
				int val = qu.remove();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("peek")) {
				int val = qu.peek();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("size")) {
				System.out.println(qu.size());
			}
			str = br.readLine();
		}
	}
}
