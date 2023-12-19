package Time_and_space;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class _26_Find_All_Four_Sum_Numbers {

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

	
    public static void main(String args[]) {
    	int arr[] = {0,0,2,1,1};
    	int k = 3;
    	System.out.println(new _26_Find_All_Four_Sum_Numbers().fourSum(arr, k));
    }
    
}
