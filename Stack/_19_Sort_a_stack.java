package Stack;

import java.util.Stack;

public class _19_Sort_a_stack {

	public void place(Stack<Integer> st, int no) {
		if (st.isEmpty() || st.peek() <= no) {
			st.push(no);
		} else {
			int x = st.pop();
			place(st, no);
			st.push(x);
		}
	}

	public Stack<Integer> sort(Stack<Integer> st) {
		if (st.size() == 1)
			return st;
		int top = st.pop();
		Stack<Integer> cAns = sort(st);
		place(cAns, top);
		return cAns;
	}

}
