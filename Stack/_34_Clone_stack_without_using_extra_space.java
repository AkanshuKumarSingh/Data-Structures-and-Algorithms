package Stack;

import java.util.Stack;

public class _34_Clone_stack_without_using_extra_space {

	void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
		int sz = st.size() - 1, low = 0;
		while (sz >= 0) {
			for (int i = 0; i < sz; i++) {
				cloned.push(st.pop());
			}
			low = st.pop();
			for (int i = 0; i < sz; i++) {
				st.push(cloned.pop());
			}
			cloned.push(low);
			sz--;
		}
	}

}
