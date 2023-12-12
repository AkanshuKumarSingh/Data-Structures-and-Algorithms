package Stack;

class stack<T> {
	private Object[] arr;
	int tos = 0;

	stack(int cap) {
		arr = new Object[cap];
		tos = 0;
	}

	public void push(T data) {
		if (tos == arr.length) {
			System.out.println("stack overflow");
			return;
		}
		arr[tos++] = data;
	}

	public T pop() {
		if (tos == 0) {
			System.out.println("stack underflow");
			return null;
		}
		tos--;
		return (T) arr[tos];
	}

	public T peek() {
		if (tos == 0) {
			System.out.println("stack underflow");
			return null;
		}
		return (T) arr[tos - 1];
	}

	public void display() {
		System.out.print("[");
		for(int i = 0 ;i < tos-1; i++) {
			System.out.print(arr[i] + ", ");
		}
		if(tos > 0) {
			System.out.print(arr[tos-1]);
		}
		System.out.println("]");
	}
	
	public String toString() {
		String str = "[";
		for (int i = 0; i < tos - 1; i++) {
			str += arr[i] + ", ";
		}
		if (tos > 0) {
			str += arr[tos-1];
		}
		str += "]";
		return str;
	}
}

public class MyStack {

	public static void main(String[] args) {
		stack<String> st = new stack<>(5);
		st.push("Aks");
		st.push("is");
		System.out.println(st);
		st.push("the");
		st.push("best");
		st.display();
		st.push(".");
		System.out.println(st);
		System.out.println(st.pop());
		st.display();
		
	}

}
