package Array;

import java.util.ArrayList;

public class _19_Find_duplicates_in_an_array {

    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        int temp[] = new int[n];
        
        for(int i : arr){
            temp[i]++;
        }
        
        for(int i = 0 ; i < n ; i++){
            if(temp[i] > 1){
                ans.add(i);
            }    
        }
        
        if(ans.size() == 0){
            ans.add(-1);
        }
        
        return ans;
    }

}
