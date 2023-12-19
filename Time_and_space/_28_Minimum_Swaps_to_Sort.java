package Time_and_space;

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
    }
    
    public void swap(int arr[], int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
	
}
