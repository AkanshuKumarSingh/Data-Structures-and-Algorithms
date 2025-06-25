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

	
//    class Solution:
//        def allSubsets(self, arr: List[int]) -> List[List[int]]:
//            arr.sort()
//            ans = []
//            subset = []
//            seen = set()
//            self._generate(arr, 0, len(arr), subset, ans, seen)
//            return ans
//
//        def _generate(self, arr, i, n, subset, ans, seen):
//            # Convert list to tuple to make it hashable for the set
//            subset_tuple = tuple(subset)
//            if subset_tuple not in seen:
//                ans.append(list(subset))
//                seen.add(subset_tuple)
//
//            if i >= n:
//                return
//
//            # Include arr[i]
//            subset.append(arr[i])
//            self._generate(arr, i + 1, n, subset, ans, seen)
//            subset.pop()
//
//            # Exclude arr[i]
//            self._generate(arr, i + 1, n, subset, ans, seen)

    
}
