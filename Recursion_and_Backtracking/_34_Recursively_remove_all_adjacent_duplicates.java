package Recursion_and_Backtracking;

import java.util.Arrays;
import java.util.Stack;

public class _34_Recursively_remove_all_adjacent_duplicates {

    String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();
        while(true){
            char ch = '@';
            boolean isDup = false;
            int n = s.length();
            for(int i = 0 ; i < n ; i++){
                if(i+1 < n && s.charAt(i) == s.charAt(i+1)){
                    ch = s.charAt(i);
                    isDup = true;
                }
                if(s.charAt(i) != ch){
                    ch = s.charAt(i);
                    ans.append(ch);
                }
            }
            if(!isDup) break;
            s = ans.toString();
            ans.setLength(0);
        }
        return ans.toString();
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
		String S = "ccbbc";
		System.out.println(new _34_Recursively_remove_all_adjacent_duplicates().removeDuplicates(S));
	}

}
