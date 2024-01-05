package Stack;

import java.util.Stack;

public class _21_Special_Stack {

	public void push(int a, Stack<Integer> s) {
		s.push(a);
	}

	public int pop(Stack<Integer> s) {
		if (s.isEmpty())
			return -1;
		return s.pop();
	}

	public int min(Stack<Integer> s) {
		int ans = Integer.MAX_VALUE;
		for (int i : s) {
			ans = Math.min(i, ans);
		}
		return ans;
	}

	public boolean isFull(Stack<Integer> s, int n) {
		return s.size() == n;
	}

	public boolean isEmpty(Stack<Integer> s) {
		return s.isEmpty();
	}
	
}
