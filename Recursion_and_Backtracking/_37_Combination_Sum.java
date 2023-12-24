package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class _37_Combination_Sum {

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> cans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        set.addAll(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);
        getCombinationSum(arr, sum, 0, cans, ans);
        return ans;
    }
    
    static void getCombinationSum(ArrayList<Integer> arr, int sum, int idx, ArrayList<Integer> cans, 
    ArrayList<ArrayList<Integer>> ans){
        if(idx == arr.size()){
            if(sum == 0){
                ArrayList<Integer> t = new ArrayList<>();
                t.addAll(cans);
                ans.add(t);
            }
            return;
        }
        
        if(sum-arr.get(idx) >= 0){
            cans.add(arr.get(idx));
            getCombinationSum(arr, sum-arr.get(idx), idx, cans, ans);
            cans.remove(cans.size()-1);
        }

        getCombinationSum(arr, sum, idx+1, cans, ans);

    }
	
}
