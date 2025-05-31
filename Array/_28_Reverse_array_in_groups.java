package Array;

import java.util.ArrayList;

public class _28_Reverse_array_in_groups {

    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        
        int i = 0;
        while(i < n){
            int st = i, ed = i + k -1;
            if(ed >= n){
                ed = n-1;
            }
            while(st < ed){
                int stEle = arr.get(st);
                int edEle = arr.get(ed);
                arr.set(st, edEle);
                arr.set(ed, stEle);
                st++;
                ed--;
            }
            i = i+k;
        }
        
    }

//    def reverse_in_groups(arr, n, k):
//        i = 0
//        while i < n:
//            start = i
//            end = min(i + k - 1, n - 1)
//            while start < end:
//                arr[start], arr[end] = arr[end], arr[start]
//                start += 1
//                end -= 1
//            i += k
    
}
