package Sorting;

import java.util.Arrays;

public class _25_Count_the_triplets {

    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int cnt=0;
         for(int i = n-1; i >= 0; i--){
             int no = arr[i];
             int l = 0, r = i-1;
             while(l < r){
                 if(arr[l]+arr[r]-no == 0){
                     l++;
                     r--;
                     cnt++;
                 }else if(arr[l]+arr[r]-no < 0){
                     l++;
                 }else{
                     r--;
                 }
             }
         }
         return cnt;
     }

//    def count_triplet(arr):
//        arr.sort()
//        n = len(arr)
//        cnt = 0
//        for i in range(n - 1, -1, -1):
//            no = arr[i]
//            l, r = 0, i - 1
//            while l < r:
//                if arr[l] + arr[r] == no:
//                    cnt += 1
//                    l += 1
//                    r -= 1
//                elif arr[l] + arr[r] < no:
//                    l += 1
//                else:
//                    r -= 1
//        return cnt

}
