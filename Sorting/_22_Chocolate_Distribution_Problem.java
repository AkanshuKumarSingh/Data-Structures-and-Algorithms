package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class _22_Chocolate_Distribution_Problem {

    public long findMinDiff (ArrayList<Integer> arr, int n, int m)
    {
        Collections.sort(arr);
        int min = arr.get(0), max = arr.get(m-1), ans = max-min;
        for(int i = m; i < n; i++){
            max = arr.get(i);
            min = arr.get(i-m+1);
            ans = Math.min(ans, max-min);
        }
        return ans;
    }

//    def find_min_diff(arr, n, m):
//        arr.sort()
//        min_diff = arr[m - 1] - arr[0]
//        
//        for i in range(m, n):
//            curr_diff = arr[i] - arr[i - m + 1]
//            min_diff = min(min_diff, curr_diff)
//        
//        return min_diff

    
}
