package Stack;

import java.util.Stack;

public class _22_Count_the_Reversals {

    int countRev2 (String expr)
    {
        int len = expr.length();
        int ans = 0;

        int left_brace = 0, right_brace = 0;
        for (int i = 0; i < len; i++) {
            char ch = expr.charAt(i);

            if (ch == '{') {
                left_brace++;
            }else {
                if (left_brace == 0) {
                    right_brace++;
                }
                else {
                    left_brace--;
                }
            }
        }
        if((left_brace+right_brace)%2 == 1) return -1;

        ans += left_brace/2;
        left_brace = left_brace%2;

        ans += right_brace/2;
        right_brace = right_brace%2;
        
        if(left_brace == 0) return ans;        
        return ans + 2;

    }

	
    int countRev1 (String s)
    {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{'){
                st.push(i);
            }else{
                if(!st.isEmpty() && s.charAt(st.peek()) == '{'){
                    st.pop();
                }else{
                    st.push(i);
                }
            }
        }

        if(st.size()%2 == 1) return -1;
        int l = 0, r = 0, ans = 0;
        while(!st.isEmpty() && s.charAt(st.peek()) == '{'){
            r++;
            st.pop();
        }
        ans += (r/2);
        r = r%2;

        while(!st.isEmpty()){
            l++;
            st.pop();
        }
        ans += (l/2);
        l = l%2;
        if(l+r == 0) return ans;
        return ans + 2;
    }

	
	int countRev(String str) {
		if (str.length() % 2 == 1)
			return -1;

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '{') {
				st.push(ch);
			} else {
				if (!st.isEmpty() && st.peek() == '{') {
					st.pop();
				} else {
					st.push('}');
				}
			}
		}

		int sz = st.size(), m = 0;
		while (!st.isEmpty() && st.peek() == '{') {
			m++;
			st.pop();
		}
		return (int) (Math.ceil((float) m / 2) + Math.ceil((float) (sz - m) / 2));
	}

}
