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

//    def get_min_diff(arr, n, k):
//        arr.sort()
//        min_ele = arr[0] + k
//        max_ele = arr[-1] - k
//        result = arr[-1] - arr[0]
//
//        for i in range(n - 1):
//            curr_max = max(max_ele, arr[i] + k)
//            curr_min = min(min_ele, arr[i + 1] - k)
//            if curr_min >= 0:
//                result = min(result, curr_max - curr_min)
//
//        return result


}
