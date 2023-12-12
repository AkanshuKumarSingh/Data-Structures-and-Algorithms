package Array;

import java.util.HashMap;

public class _26_Count_pairs_with_given_sum {

    int getPairsCount(int[] arr, int n, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        
        for(int i : arr){
            int diff = k - i;
            if(map.containsKey(diff)){
                cnt += map.get(diff);
            }
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        return cnt;
    }
	
}
