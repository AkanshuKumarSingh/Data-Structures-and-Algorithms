package Stack;

public class StackTest<T> {
	Object data[];
	int tos;
	
	StackTest(int size){
		data = new Object[size];
		tos = -1;
	}
	
	public int size() {
		return tos+1;
	}
	
	void increaseSize() {
		Object newData[] = new Object[data.length*2];
		for(int i = 0; i < data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
	
	void display() {
		for(int i = 0 ; i <= tos; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	void push(T no) {
		if(data.length-1 == tos) {
			increaseSize();
		}
		data[++tos] = no;
	}
	
	T pop() {
		if(tos == -1) {
			System.out.println("Stack underflow");
			return null;
		}
		return (T)data[tos--];
	}
	
	T top() {
		if(tos == -1) {
			System.out.println("Stack underflow");
			return null;
		}
		return (T)data[tos--];
	}
	
	public static void main(String[] args) {		
		StackTest<String> stack = new StackTest<>(5);
		stack.push("2");
		stack.display();
		stack.push("5");
		stack.push("1");
		stack.push("3");
		stack.display();
		stack.push("7");
		stack.display();
		stack.push("2");
		stack.display();
		System.out.println(stack.pop());
		stack.display();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.display();
	}

}
