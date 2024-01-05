package Stack;

import java.util.Stack;

public class _16_Delete_middle_element_of_stack {

	public void deleteMid(Stack<Integer> s, int sizeOfStack) {
		Stack<Integer> t = new Stack<>();
		sizeOfStack = sizeOfStack / 2;
		while (sizeOfStack-- > 0) {
			t.push(s.pop());
		}
		s.pop();
		while (!t.isEmpty()) {
			s.push(t.pop());
		}
	}

}
