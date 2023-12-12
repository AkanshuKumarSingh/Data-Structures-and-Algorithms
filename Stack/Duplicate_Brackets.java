package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Duplicate_Brackets {

	// if str contains extra brackets

	public static boolean hasDuplicates(String str) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch == ' ') {
				continue;
			} else if (ch == ')') {
				// if before ) directly ( is present in stack means there is extra bracket
				// because even if others brackets are popped then also some operator must
				// be present ( (a+b) + (n+m)) -> ( + )
				// in mostly case operators and operands both should be present ( a+b)
				if (st.peek() == '(') {
					return true;
				} else {
					while (st.peek() != '(') {
						st.pop();
					}
					st.pop();
				}
			} else {
				// we can also just put operators that is also suffiecient
				st.push(ch);
			}

		}
		return false;
	}

	public static boolean hasDuplicates1(String str) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ')') {
				// if closes then pop out
				if (st.peek() == '(') {
					return true;
				}
				while (st.peek() != '(') {
					st.pop();
				}
				st.pop();
			} else {
				// else push in stack
				if (ch == '(') {
					st.push(ch);
				} else if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch == ' ') {
					continue;
				} else {
					st.push(ch);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().trim();

		// First way
		System.out.println(hasDuplicates1(str));

		// Second way
		System.out.println();
	}

}
