package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class _11_Smallest_Number_Following_Pattern {

    static String printMinNumberForPattern(String str) {
        Stack<Integer> st = new Stack<>();
        int count = 1;
        String ans = "";
        st.push(count);
        count++;
        
        for(int i= 0 ; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'D'){
                st.push(count++);
            }else{
                while(!st.isEmpty()){
                    ans += st.pop();
                }
                st.push(count++);
            }
        }
        
        while(!st.isEmpty()){
            ans += st.pop();
        }
        return ans;
    }

//    def print_min_number_for_pattern(pattern: str) -> str:
//        stack = []
//        count = 1
//        result = ""
//
//        stack.append(count)
//        count += 1
//
//        for ch in pattern:
//            if ch == 'D':
//                stack.append(count)
//                count += 1
//            else:  # 'I'
//                while stack:
//                    result += str(stack.pop())
//                stack.append(count)
//                count += 1
//
//        while stack:
//            result += str(stack.pop())
//
//        return result

    
	public static void smallestNumberFollowingPattern(String pattern) {
		Stack<Integer> st = new Stack<>();
		int count = 1;

		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if (ch == 'd') {
				st.push(count);
				count++;
			} else {
				st.push(count);
				count++;
				while (st.size() > 0) {
					System.out.print(st.pop());
				}
			}
		}
		st.push(count);

		while (st.size() > 0) {
			System.out.print(st.pop());
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		smallestNumberFollowingPattern(str);
	}

}
