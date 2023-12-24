package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class _22_Generate_Parentheses {

	// https://leetcode.com/problems/generate-parentheses/

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, n, 2*n, "", ans);
        return ans;
    }

    public static void generate(int left, int right, int length, String asf, List<String> ans){
        if(asf.length() == length){
            ans.add(asf);
            return;
        }

        if(left > 0)
            generate(left-1, right, length, asf+"(", ans);
        if(left < right){
            generate(left, right-1, length, asf+")", ans);
        }

    }

}
