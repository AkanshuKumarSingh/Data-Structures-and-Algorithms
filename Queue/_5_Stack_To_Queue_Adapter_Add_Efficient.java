package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _5_Stack_To_Queue_Adapter_Add_Efficient {

	public static class StackToQueueAdapter {
		Stack<Integer> mainS;
		Stack<Integer> helperS;

		public StackToQueueAdapter() {
			mainS = new Stack<>();
			helperS = new Stack<>();
		}

		int size() {
			return mainS.size();
		}

		void add(int val) {
			mainS.push(val);
		}

		int remove() {
			if(this.size() == 0) {
				System.out.println("Queue is Empty");
				return -1;
			}
			
			while(mainS.size() > 1) {
				helperS.add(mainS.pop());
			}
			
			int no = mainS.pop();
			
			while(helperS.size() > 0) {
				mainS.add(helperS.pop());
			}
			
			return no;
		}

		int peek() {
			if(this.size() == 0) {
				System.out.println("Queue is Empty");
				return -1;
			}
			
			while(mainS.size() > 1) {
				helperS.add(mainS.pop());
			}
			
			int no = mainS.pop();
			helperS.add(no);
			
			while(helperS.size() > 0) {
				mainS.add(helperS.pop());
			}
			
			return no;
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
