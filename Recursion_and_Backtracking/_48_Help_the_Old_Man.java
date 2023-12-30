package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class _48_Help_the_Old_Man {

    static int move = 0;
    static List<Integer> ans = new ArrayList<>();
    static void toh(int n, int k, int src, int help, int dest){
        if(ans.size() != 0) return;
        if(n == 0) return;
        toh(n-1, k, src, dest, help);
        move++;
        if(move == k){
            ans.add(src);
            ans.add(dest);
        }
        toh(n-1, k, help, src, dest);
        
    }
    
    static List<Integer> shiftPile(int N, int n){
        move = 0;
        ans.clear();
        toh(N, n, 1, 2, 3);
        return ans;
    }
	
}
