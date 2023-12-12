package Array;

import java.util.Arrays;

public class _25_Minimum_Platforms {

    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int ans = 0,cnt = 0, i = 0, j = 0;
        while(i < n){
            if(arr[i] <= dep[j]){
                cnt++;
                ans = Math.max(ans, cnt);
                i++;
            }else{
                cnt--;
                j++;
            }
        }
        return ans;
    }

}
