package Array;

import java.util.Arrays;

public class _22_Minimize_the_Heights_II {
	
//	https://www.youtube.com/watch?v=29uyA4F9t5I

    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int minEle = arr[0]+k ,maxEle = arr[n-1]-k, result = arr[n-1] - arr[0];
        int currMax, currMin;
        for(int i = 0 ; i < n-1; i++){
            currMax = Math.max(maxEle, arr[i]+k);
            currMin = Math.min(minEle, arr[i+1]-k);
            if(currMin >= 0) {
            	result = Math.min(result, currMax-currMin);
            }
        }
        return result;
    }


}
