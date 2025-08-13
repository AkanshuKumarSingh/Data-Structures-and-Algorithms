package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class _31_Next_Greater_Element {

    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] sol = new int[n];
        
        ArrayList<Integer> list = new ArrayList<>(arr.length);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            stack.push(arr[i]);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            sol[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        
        for (int i = 0; i < n; i++) {
            list.add(sol[i]);
        }
        
        return list;
    }
	
	public static long[] nextLargerElement(long[] arr, int n) {
		long ans[] = new long[n];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
				ans[st.pop()] = arr[i];
			}
			st.push(i);
		}
		while (!st.isEmpty())
			ans[st.pop()] = -1;
		return ans;
	}

}
