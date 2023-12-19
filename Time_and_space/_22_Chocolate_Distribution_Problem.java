package Time_and_space;

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
	
}
