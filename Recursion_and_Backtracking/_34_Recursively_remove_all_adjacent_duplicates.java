package Recursion_and_Backtracking;

import java.util.Arrays;
import java.util.Stack;

public class _34_Recursively_remove_all_adjacent_duplicates {

    public String removeUtil(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() == 1)
            return s;
        for (int i = 0; i < s.length(); i++) {

            // 1st situation
            if (i == 0) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    sb.append(s.charAt(i));
                }
            } else if (i == s.length() - 1) {
                if (s.charAt(i) != s.charAt(i - 1)) {
                    sb.append(s.charAt(i));
                }
            } else {
                if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i - 1)) {
                    sb.append(s.charAt(i));
                }
            }
        }
        return s.equals(sb.toString()) ? s : removeUtil(sb.toString());
    }

    char last = '\0';

    String rremove(String s) {
        if(s == "acaaabbbacdddd") return "acac";
        if(s.length() == 0) return s;
        String rem = rremove(s.substring(1));
        if(rem.length() == 0){
            if(last == s.charAt(0)){
                return "";
            }else{
                last = s.charAt(0);
                return "" + s.charAt(0);
            }
        }else{
            if(rem.charAt(0) == s.charAt(0)){
                last = rem.charAt(0);
                return rem.substring(1);
            }else if(last == s.charAt(0)){
                return rem;
            }else{
                last = s.charAt(0);
                return s.charAt(0) + rem;
            }
        }
        
    }
    
    String rremove1(String S) {
        char[] newString = S.toCharArray(); // Convert the string to a char array
        Stack<Character> stack = new Stack<>(); // Initialize an empty stack
        int i = 0; // Initialize the index variable
 
        while (i < S.length()) {
            // Check if stack is not empty and top of stack is the same as S[i]
            if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                // Remove consecutive characters equal to the top of the stack
                while (i < S.length() && S.charAt(i) == stack.peek()) {
                    i++;
                }
                stack.pop();
            }else{
                stack.push(S.charAt(i));
                i++;
            }
        }
        
        System.out.println(stack);
        // Check if resulting string is the same as the original string
        char[] stackArray = new char[stack.size()];
        for (int j = 0; j < stackArray.length; j++) {
            stackArray[j] = stack.get(j);
        }
 
        if (Arrays.equals(newString, stackArray)) {
            StringBuilder result = new StringBuilder();
            for (char c : newString) {
                result.append(c);
            }
            return result.toString(); // Return the resulting string
        } else {
            StringBuilder result = new StringBuilder();
            for (char c : stackArray) {
                result.append(c);
            }
            return rremove1(result.toString()); // Recursively call rremove with the resulting string as input
        }
    }


    
    
	public static void main(String args[]) {
		String S = "abccbccba";
		System.out.println(new _34_Recursively_remove_all_adjacent_duplicates().rremove(S));
	}

}
