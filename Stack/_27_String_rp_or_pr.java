package Stack;

import java.util.Stack;

public class _27_String_rp_or_pr {

	static String str;

	static long removePattern(String S, String pattern, int cost) {
		Stack<Character> stack = new Stack<>();
		long score = 0;

		for (char ch : S.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == pattern.charAt(0) && ch == pattern.charAt(1)) {
				stack.pop();
				score += cost;
			} else {
				stack.push(ch);
			}
		}

		StringBuilder remaining = new StringBuilder();
		while (!stack.isEmpty()) {
			remaining.insert(0, stack.pop());
		}

		str = remaining.toString();
		return score;
	}

	static long solve1(int X, int Y, String S) {
		long ans = 0;
		if (X > Y) {
			ans += removePattern(S, "pr", X);
			ans += removePattern(str, "rp", Y);
		} else {
			ans += removePattern(S, "rp", Y);
			ans += removePattern(str, "pr", X);
		}
		return ans;
	}


//	str_global = ""  # acts like static variable
//
//	def remove_pattern(S: str, pattern: str, cost: int) -> int:
//	    global str_global
//	    stack = []
//	    score = 0
//
//	    for ch in S:
//	        if stack and stack[-1] == pattern[0] and ch == pattern[1]:
//	            stack.pop()
//	            score += cost
//	        else:
//	            stack.append(ch)
//
//	    remaining = ''.join(stack)
//	    str_global = remaining
//	    return score
//
//
//	def solve1(X: int, Y: int, S: str) -> int:
//	    global str_global
//	    ans = 0
//	    if X > Y:
//	        ans += remove_pattern(S, "pr", X)
//	        ans += remove_pattern(str_global, "rp", Y)
//	    else:
//	        ans += remove_pattern(S, "rp", Y)
//	        ans += remove_pattern(str_global, "pr", X)
//	    return ans

	
	
	static long solve(int X, int Y, String S) {
		int n = S.length();
		long ans = 0;
		if (n == 0)
			return 0;
		boolean pr = false, rp = false;
		for (int i = 1; i < n; i++) {
			String sub = S.substring(i - 1, i + 1);
			if (sub.equals("pr") && !pr) {
				ans = Math.max(X + solve(X, Y, S.substring(0, i - 1) + S.substring(i + 1)), ans);
				pr = !pr;
			} else if (sub.equals("rp") && !rp) {
				ans = Math.max(Y + solve(X, Y, S.substring(0, i - 1) + S.substring(i + 1)), ans);
				rp = !rp;
			}

			if (pr && rp)
				break;
		}
		return ans;
	}

}
