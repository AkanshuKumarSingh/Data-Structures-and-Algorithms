package Stack;

public class _17_Implement_Stack_using_Linked_List {

	class StackNode {
		int data;
		StackNode next;

		StackNode(int a) {
			data = a;
			next = null;
		}
	}

	StackNode top;

	// Function to push an integer into the stack.
	void push(int a) {
		if (top == null) {
			StackNode node = new StackNode(a);
			top = node;
		} else {
			StackNode node = new StackNode(a);
			node.next = top;
			top = node;
		}
	}

	// Function to remove an item from top of the stack.
	int pop() {
		if (top == null) {
			return -1;
		} else {
			int ans = top.data;
			top = top.next;
			return ans;
		}
	}

}
