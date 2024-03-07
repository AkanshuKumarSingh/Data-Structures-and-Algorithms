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
        
        
//        python code
//        arrival.sort()
//        departure.sort()
//        
//        ans = 0
//        cnt = 0
//        i = 0
//        j = 0
//        
//        while i < len(arrival):
//            if arrival[i] <= departure[j]:
//                cnt += 1
//                ans = max(ans, cnt)
//                i += 1
//            else:
//                cnt -= 1
//                j += 1
//        
//        return ans
    }

}
