package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Two_Stacks_In_An_Array {
	
//	https://practice.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1

	public static class TwoStack {
		int[] data;
		int i;
		int j;

		public TwoStack(int cap) {
			data = new int[cap];
			i = 0;
			j = cap-1;
		}

		int size1() {
			return i;
		}

		int size2() {
			return data.length-j-1;
		}

		void push1(int val) {
			if(i <= j) {
				data[i++] = val;
			}else {
				System.out.println("Stack overflow");
				return;				
			}
		}

		void push2(int val) {
			if(i <= j) {
				data[j--] = val;
			}else {
				System.out.println("Stack overflow");
				return;
			}
		}

		int pop1() {
			if(i == 0) {
				System.out.println("Stack underflow");
				return -1;
			}else {
				int val = data[i-1];
				i--;
				return val;
			}
			
		}

		int pop2() {
			if(j == data.length-1) {
				System.out.println("Stack underflow");
				return -1;
			}else {
				int val = data[j+1];
				j++;
				return val;
			}
		}

		int top1() {
			if(i == 0) {
				System.out.println("Stack underflow");
				return -1;
			}else {
				return data[i-1];
			}
		}

		int top2() {
			if(j == data.length-1) {
				System.out.println("Stack underflow");
				return -1;
			}else {
				return data[j+1];
			}
		}
	}

	
//	public static class TwoStack {
//		int[] data;
//		int tos1;
//		int tos2;
//
//		public TwoStack(int cap) {
//			data = new int[cap];
//			tos1 = -1;
//			tos2 = cap;
//		}
//
//		int size1() {
//			return tos1-1;
//		}
//
//		int size2() {
//			return data.length-tos2;
//		}
//
//		void push1(int val) {
//			if(tos1 + 1 == tos2) {
//				System.out.println("Stack overflow");
//				return;
//			}
//			data[++tos1] = val;
//		}
//
//		void push2(int val) {
//			if(tos2 - 1 == tos1) {
//				System.out.println("Stack overflow");
//				return;
//			}
//			data[--tos2] = val;
//		}
//
//		int pop1() {
//			if(tos1 == -1) {
//				System.out.println("Stack underflow");
//				return -1;
//			}
//			int ans = data[tos1];
//			tos1--;
//			return ans;
//		}
//
//		int pop2() {
//			if(tos2 == data.length) {
//				System.out.println("Stack underflow");
//				return -1;
//			}
//			int ans = data[tos2];
//			tos2++;
//			return ans;
//		}
//
//		int top1() {
//			if(tos1 == -1) {
//				System.out.println("Stack underflow");
//				return -1;
//			}
//			int ans = data[tos1];
//			return ans;
//		}
//
//		int top2() {
//			if(tos2 == data.length) {
//				System.out.println("Stack underflow");
//				return -1;
//			}
//			int ans = data[tos2];
//			return ans;
//		}
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TwoStack st = new TwoStack(n);

		String str = br.readLine();
		while (str.equals("quit") == false) {
			if (str.startsWith("push1")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				st.push1(val);
			} else if (str.startsWith("pop1")) {
				int val = st.pop1();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("top1")) {
				int val = st.top1();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("size1")) {
				System.out.println(st.size1());
			} else if (str.startsWith("push2")) {
				int val = Integer.parseInt(str.split(" ")[1]);
				st.push2(val);
			} else if (str.startsWith("pop2")) {
				int val = st.pop2();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("top2")) {
				int val = st.top2();
				if (val != -1) {
					System.out.println(val);
				}
			} else if (str.startsWith("size2")) {
				System.out.println(st.size2());
			}
			str = br.readLine();
		}
	}
}
