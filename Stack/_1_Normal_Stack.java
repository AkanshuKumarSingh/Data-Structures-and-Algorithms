package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1_Normal_Stack {

	public static class CustomStack {
		int[] data;
		int tos;

		public CustomStack(int cap) {
			data = new int[cap];
			tos = -1;
		}

		int size() {
			return tos + 1;
		}

		void display() {
			for(int i = tos; i <= tos; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}

		void push(int val) {
			if(tos == data.length-1) {
				System.out.println("Stack overflow");
				return;
			}
			data[++tos] = val;
		}

		int pop() {
			if(tos == -1) {
				System.out.println("Stack underflow");
				return -1;
			}
			tos--;
			return data[tos+1];
		}

		int top() {
			if(tos == -1) {
				System.out.println("Stack underflow");
				return -1;
			}
			return data[tos];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		CustomStack st = new CustomStack(n);

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
			} else if (str.startsWith("display")) {
				st.display();
			}
			str = br.readLine();
		}
	}
	
//	class CustomStack:
//	    def __init__(self, cap):
//	        self.data = [0] * cap
//	        self.tos = -1
//
//	    def size(self):
//	        return self.tos + 1
//
//	    def display(self):
//	        for i in range(self.tos, -1, -1):
//	            print(self.data[i], end=" ")
//	        print()
//
//	    def push(self, val):
//	        if self.tos == len(self.data) - 1:
//	            print("Stack overflow")
//	            return
//	        self.tos += 1
//	        self.data[self.tos] = val
//
//	    def pop(self):
//	        if self.tos == -1:
//	            print("Stack underflow")
//	            return -1
//	        val = self.data[self.tos]
//	        self.tos -= 1
//	        return val
//
//	    def top(self):
//	        if self.tos == -1:
//	            print("Stack underflow")
//	            return -1
//	        return self.data[self.tos]
//
//
//	def main():
//	    import sys
//	    cap = int(sys.stdin.readline())
//	    st = CustomStack(cap)
//
//	    while True:
//	        line = sys.stdin.readline().strip()
//	        if line == "quit":
//	            break
//	        elif line.startswith("push"):
//	            val = int(line.split()[1])
//	            st.push(val)
//	        elif line == "pop":
//	            val = st.pop()
//	            if val != -1:
//	                print(val)
//	        elif line == "top":
//	            val = st.top()
//	            if val != -1:
//	                print(val)
//	        elif line == "size":
//	            print(st.size())
//	        elif line == "display":
//	            st.display()
//
//
//	if __name__ == "__main__":
//	    main()


}
