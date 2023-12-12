package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// Infix -> Inorder ( Left Root Right ) -> val1 operator val2
// Postfix -> PostOrder ( Left Right Root) -> val1 val2 operator
// Prefix -> Prefix (Root Left Right ) -> operator val1 val2

public class evaluation {

	public static int priority(char op) {
		if (op == '*' || op == '/') {
			return 2;
		} else if (op == '+' || op == '-') {
			return 1;
		} else {
			return 0;
		}
	}

	public static int evaluate(int val1, int val2, char op) {
		if (op == '*') {
			return val1 * val2;
		} else if (op == '/') {
			return val1 / val2;
		} else if (op == '+') {
			return val1 + val2;
		} else if (op == '-') {
			return val1 - val2;
		} else {
			return 0;
		}
	}

	// infix
	public static int infixEvaluation(String exp) {
		Stack<Character> oStack = new Stack<>();
		Stack<Integer> vStack = new Stack<>();

		// higher priority operator can be pushed over lower priority operator

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch == ' ') {
				continue;
			} else if (ch >= '0' && ch <= '9') {
				vStack.push((int) (ch - '0'));
			} else if (ch == '(') {
				oStack.push(ch);
			} else if (ch == ')') {
				while (oStack.peek() != '(') {
					char op = oStack.pop();
					int val2 = vStack.pop();
					int val1 = vStack.pop();

					int res = evaluate(val1, val2, op);
					vStack.push(res);
				}
				oStack.pop();
			} else {
				while (oStack.size() > 0 && oStack.peek() != '(' && priority(oStack.peek()) >= priority(ch)) {
					char op = oStack.pop();
					int val2 = vStack.pop();
					int val1 = vStack.pop();

					int res = evaluate(val1, val2, op);
					vStack.push(res);
				}
				oStack.push(ch);
			}

		}

		while (oStack.size() > 0) {
			char op = oStack.pop();
			int val2 = vStack.pop();
			int val1 = vStack.pop();

			int res = evaluate(val1, val2, op);
			vStack.push(res);
		}

		return vStack.peek();

	}

	public static void infixToPrefix(String exp) {
		Stack<Character> oStack = new Stack<>();
		Stack<String> vStack = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
//			System.out.println(oStack);
//			System.out.println(vStack);
			if (ch == ' ') {
				continue;
			} else if (ch >= 'a' && ch <= 'z') {
				vStack.push("" + ch);
			} else if (ch == '(') {
				oStack.push(ch);
			} else if (ch == ')') {
				while (oStack.peek() != '(') {
					char op = oStack.pop();
					String val2 = vStack.pop();
					String val1 = vStack.pop();

					String res = op + val1 + val2;
					vStack.push(res);
				}
				oStack.pop();
			} else {
				while (oStack.size() > 0 && oStack.peek() != '(' && priority(oStack.peek()) >= priority(ch)) {
					char op = oStack.pop();
					String val2 = vStack.pop();
					String val1 = vStack.pop();

					String res = op + val1 + val2;
					vStack.push(res);
				}
				oStack.push(ch);
			}

		}

		while (oStack.size() > 0) {
			char op = oStack.pop();
			String val2 = vStack.pop();
			String val1 = vStack.pop();

			String res = op + val1 + val2;
			vStack.push(res);
		}
		System.out.println(vStack.pop());
	}

	public static void infixToPostfix(String exp) {
		Stack<Character> oStack = new Stack<>();
		Stack<String> vStack = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch == ' ') {
				continue;
			} else if (ch >= 'a' && ch <= 'z') {
				vStack.push("" + ch);
			} else if (ch == '(') {
				oStack.push(ch);
			} else if (ch == ')') {
				while (oStack.peek() != '(') {
					char op = oStack.pop();
					String val2 = vStack.pop();
					String val1 = vStack.pop();

					String res = val1 + val2 + op;
					vStack.push(res);
				}
				oStack.pop();
			} else {
				while (oStack.size() > 0 && oStack.peek() != '(' && priority(oStack.peek()) >= priority(ch)) {
					char op = oStack.pop();
					String val2 = vStack.pop();
					String val1 = vStack.pop();

					String res = val1 + val2 + op;
					vStack.push(res);
				}
				oStack.push(ch);
			}

		}

		while (oStack.size() > 0) {
			char op = oStack.pop();
			String val2 = vStack.pop();
			String val1 = vStack.pop();

			String res = val1 + val2 + op;
			vStack.push(res);
		}
		System.out.println(vStack.pop());

	}

//	// postfix
	public static void postfixEvaluation(String exp) {
		Stack<Integer> st = new Stack<>();

		// In postfix we didn't need to check anything about priority because when we
		// convert infix to postfix all the operation come by sequence i.e first
		// operator means this operation has be first this is all managed in infix to
		// postfix so to solve postfix just popped out nos when there is operator
		// and do the operation.
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch >= '0' && ch <= '9') {
				st.push((int) (ch - '0'));
			} else {
				int val2 = st.pop();
				int val1 = st.pop();

				int res = evaluate(val1, val2, ch);
				st.push(res);
			}
		}

		System.out.println(st.peek());
	}

	public static void postfixToPrefix(String exp) {

		Stack<String> st = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch >= '0' && ch <= '9') {
				st.push("" + ch);
			} else {
				String val2 = st.pop();
				String val1 = st.pop();

				String res = ch + val1 + val2;
				st.push(res);
			}
		}

		System.out.println(st.peek());

	}

	public static void postfixToInfix(String exp) {
		Stack<String> st = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);

			if (ch >= '0' && ch <= '9') {
				st.push("" + ch);
			} else {
				String val2 = st.pop();
				String val1 = st.pop();

				String res = "(" + val1 + ch + val2 + ")";
				st.push(res);
			}
		}

		System.out.println(st.peek());

	}

//
	// prefix
	public static void prefixEvaluation(String exp) {
		Stack<Integer> st = new Stack<>();

		for (int i = exp.length() - 1; i >= 0; i--) {
			char ch = exp.charAt(i);

			if (ch >= '0' && ch <= '9') {
				st.push(ch - '0');
			} else {
				int val1 = st.pop();
				int val2 = st.pop();

				int res = evaluate(val1, val2, ch);
				st.push(res);
			}
		}
		System.out.println(st.peek());
	}

	public static void prefixToPostfix(String exp) {
		Stack<String> st = new Stack<>();

		for (int i = exp.length() - 1; i >= 0; i--) {
			char ch = exp.charAt(i);

			if (ch >= '0' && ch <= '9') {
				st.push("" + ch);
			} else {
				String val1 = st.pop();
				String val2 = st.pop();

				String res = val1 + val2 + ch;
				st.push(res);
			}
		}
		System.out.println(st.peek());
	}

	public static void prefixToInfix(String exp) {
		Stack<String> st = new Stack<>();
		
		for(int i = exp.length()-1; i >=0; i--) {
			char ch = exp.charAt(i);
			
			if(ch >= '0' && ch <= '9') {
				st.push("" + ch);
			}else {
				String val1 = st.pop();
				String val2 = st.pop();
				
				String res = "(" + val1 + ch + val2 + ")";
				st.push(res);
			}
		}
		System.out.println(st.peek());
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
//		System.out.println(infixEvaluation(exp));
//		infixToPrefix(exp);
//		infixToPostfix(exp);
		prefixEvaluation(exp);
		prefixToInfix(exp);
		prefixToPostfix(exp);
	}
}
