package Hashing;

import java.util.HashMap;

public class _12_Longest_Sub_Array_with_Sum_K {

    public static int lenOfLongSubarr (int arr[], int n, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for(int i = 0 ; i < n ; i++){
            sum += arr[i];
            if(sum == K){
                maxLen = i+1;
            }
            int prevIdx = map.getOrDefault(sum-K, -1);
            if(!map.containsKey(sum)) {
            	map.put(sum, i);
            }
            
            if(prevIdx != -1){
                maxLen = Math.max(maxLen, i-prevIdx);
            }
            
        }
        return maxLen;

    }
    
	// Drive's code
	public static void main(String arg[]) {
        int[] arr = {-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6};

		// Function call
		System.out.println("Length of the longest 0 sum subarray is " + lenOfLongSubarr(arr, arr.length, 15));
	}

	
}
