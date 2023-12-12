package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Balanced_Brackets {

	// if brackets are balanced i.e 
	// closing or opening bracket is not present : a bracket opened but not closed and vice-versa
	// type closing or opening bracket changes
	public static boolean balancebrackets(String str) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if(ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			}else if (ch == ')') {
				if(st.isEmpty() || st.peek() != '(') {
					return false;
				}
				st.pop();
			} else if (ch == ']') {
				if(st.isEmpty() || st.peek() != '[') {
					return false;
				}
				st.pop();
			} else if (ch == '}') {
				if(st.isEmpty() || st.peek() != '{') {
					return false;
				}
				st.pop();
			}

		}
		// if size is 0 then all brackets have matching pair else some opening brackets are left
		// which are never closed so ans should be false in that case
		return st.size() == 0;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().trim();
		System.out.println(balancebrackets(str));
	}

}
