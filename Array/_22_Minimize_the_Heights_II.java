package Array;

import java.util.Arrays;

public class _22_Minimize_the_Heights_II {
	
    int getMinDiff(int[] arr, int n, int k) {
        
        Arrays.sort(arr);
        int minEle = Integer.MAX_VALUE ,maxEle = Integer.MIN_VALUE, result = arr[n-1] - arr[0];
        for(int i = 1 ; i < n ; i++){
            if(arr[i] >= k){
                maxEle = Math.max(result, Math.max(arr[i-1] + k, arr[n-1]-k));
                minEle = Math.min(result, Math.min(arr[i] - k, arr[0] + k));
                result = Math.min(result, maxEle-minEle);
            }
        }
        result = maxEle-minEle;
        return result;
    }


}
