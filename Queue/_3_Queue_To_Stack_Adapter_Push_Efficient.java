package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class _3_Queue_To_Stack_Adapter_Push_Efficient {
	public static class QueueToStackAdapter {
		Queue<Integer> mainQ;
		Queue<Integer> helperQ;

		public QueueToStackAdapter() {
			mainQ = new ArrayDeque<>();
			helperQ = new ArrayDeque<>();
		}

		int size() {
			return mainQ.size();
		}

		void push(int val) {
			mainQ.add(val);
		}

		int pop() {
			if (mainQ.size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}

			while (mainQ.size() > 1) {
				helperQ.add(mainQ.remove());
			}

			int data = mainQ.remove();

			Queue<Integer> temp = mainQ;
			mainQ = helperQ;
			helperQ = temp;

			return data;
		}

		int top() {
			if (mainQ.size() == 0) {
				System.out.println("Stack underflow");
				return -1;
			}

			while (mainQ.size() > 1) {
				helperQ.add(mainQ.remove());
			}

			int data = mainQ.remove();
			helperQ.add(data);

			Queue<Integer> temp = mainQ;
			mainQ = helperQ;
			helperQ = temp;

			return data;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		QueueToStackAdapter st = new QueueToStackAdapter();

		String str = br.readLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("push")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				st.push(val);
			} else if (str.startsWith("pop")) {
				int val = st.pop();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("top")) {
				int val = st.top();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("size")) {
				System.out.println(st.size());
			}
			str = br.readLine();
		}
	}
}
