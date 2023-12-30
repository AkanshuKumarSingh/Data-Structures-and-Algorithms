package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class _52_All_Unique_Permutations_of_an_array {

    static void permutate(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr, boolean vis[],  
    ArrayList<Integer> arr, int n){
        
        if(n == 0){
            ArrayList<Integer> res = new ArrayList<>(curr);
            ans.add(res);
            return;
        }
        
        for(int i = 0; i < arr.size(); i++){
            int no = arr.get(i);
            if(vis[i]) continue;
            else if (i > 0 && (no == arr.get(i - 1)) && !vis[i - 1]) continue;
            vis[i] = true;
            curr.add(no);
            permutate(ans, curr, vis, arr, n-1);
            vis[i] = false;
            curr.remove(curr.size()-1);
        }
        
    }
    
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr , int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        Collections.sort(arr);
        boolean vis[] = new boolean[n];
        permutate(ans, curr, vis, arr, n);
        return ans;
    }
	
}
