package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class _42_Unique_Subsets {

    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        Arrays.sort(arr);
        ArrayList<ArrayList <Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        generate(arr, 0, n, subset, ans, set);
        return ans;
    }
    
    public static void generate(int arr[], int i, int n, ArrayList<Integer> subset, ArrayList<ArrayList <Integer>> ans,  HashSet<ArrayList<Integer>> set){
        if(!set.contains(subset)){
            ArrayList<Integer> bans = new ArrayList<>();
            bans.addAll(subset);
            set.add(bans);
            ans.add(bans);
        }
        if(i >= n){
            return;
        }        
        subset.add(arr[i]);
        generate(arr, i+1, n, subset, ans, set);
        subset.remove(subset.size()-1);

        generate(arr, i+1, n, subset, ans, set);
        
    }

	
}
