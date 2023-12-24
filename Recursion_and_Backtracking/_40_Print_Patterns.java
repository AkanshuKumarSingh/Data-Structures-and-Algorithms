package Recursion_and_Backtracking;

import java.util.*;

public class _40_Print_Patterns {

    public List<Integer> pattern(int N){
        if(N <= 0){
            List<Integer> bans = new ArrayList<>();
            bans.add(N);
            return bans;
        }
        List<Integer> ans = pattern(N-5);
        ans.add(0, N);
        ans.add(N);
        return ans;
    }
	
}
