package Hashing;

import java.util.*;

public class _17_Find_All_Four_Sum_Numbers {

    public ArrayList<ArrayList<Integer>> getAns(int sum, int idx, int k, int[] arr, HashSet<ArrayList<Integer>> set){
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> fans = new ArrayList<>();
        ans.add(sum);
         for(int i = idx+1; i < arr.length; i++){
             int no = arr[i];
             int l = i+1, r = arr.length-1;
             while(l < r){
                 if(arr[l]+arr[r]+no+sum == k){
                     ans.add(no);
                     ans.add(arr[l]);
                     ans.add(arr[r]);
                     if(!set.contains(ans)){
                         fans.add(ans);
                         set.add(ans);
                     }
                     ans = new ArrayList<>();
                     ans.add(sum);
                     l++;
                     r--;
                 }else if(arr[l]+arr[r]+no+sum < k){
                     l++;
                 }else{
                     r--;
                 }
             }
         }
        return fans;
    }
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> fourSumAns = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        for(int i = 0 ; i < arr.length-3; i++){
            ArrayList<ArrayList<Integer>> currAns = getAns(arr[i], i, k, arr, set);
            if(currAns.size() > 0){
                fourSumAns.addAll(currAns);
            }

        }
        return fourSumAns;
    }
	
}
