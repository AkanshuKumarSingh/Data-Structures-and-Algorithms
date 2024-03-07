package Sorting;

import java.util.Arrays;
import java.util.HashMap;

public class _28_Minimum_Swaps_to_Sort {

    public int minSwaps(int nums[])
    {
        int t[] = new int[nums.length];
        int j = 0;
        for(int i : nums){
            t[j++] = i;
        }
        Arrays.sort(t);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],i);
        }
        int cnt = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(t[i] != nums[i]){
                cnt++;
                int no = nums[i];
                swap(nums,i,map.get(t[i]));
                map.put(no,map.get(t[i]));
                map.put(t[i],i);
            }
        }
        return cnt;
        
//        python code
//        map = {}
//        for i in A1:
//            map[i] = map.get(i, 0) + 1
//        
//        j = 0
//        for i in A2:
//            if i in map:
//                time = map[i]
//                while time > 0:
//                    A1[j] = i
//                    j += 1
//                    time -= 1
//                del map[i]
//        
//        k = j
//        for i, time in map.items():
//            while time > 0:
//                A1[k] = i
//                k += 1
//                time -= 1
//        
//        A1[j:] = sorted(A1[j:])
//        return A1
    }
    
    public void swap(int arr[], int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
	
}
