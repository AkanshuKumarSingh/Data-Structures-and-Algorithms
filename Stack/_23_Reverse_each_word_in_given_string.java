package Stack;

import java.util.Stack;

public class _23_Reverse_each_word_in_given_string {

	String reverseWords(String str) {
		String ans = "", curr = "";
		Stack<Character> st = new Stack<>();

		for (char ch : str.toCharArray()) {
			st.push(ch);
		}

		while (!st.isEmpty()) {
			char ch = st.pop();
			if (ch == '.') {
				ans = ch + curr + ans;
				curr = "";
			} else {
				curr += ch;
			}
		}
		ans = curr + ans;
		return ans;
	}
	
    public String reverseWords1(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        S = S.trim();
        
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c != ' '){
                stack.push(c);
            } else{
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(' ');
            }
        }
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }

}
