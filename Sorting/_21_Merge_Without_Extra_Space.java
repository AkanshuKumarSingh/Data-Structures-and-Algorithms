package Sorting;

import java.util.Arrays;

public class _21_Merge_Without_Extra_Space {

    public static void merge(long arr1[], long arr2[], int n, int m) {
        int i = n-1, j = 0;
        while(i >= 0 && j < m){
            if(arr1[i] > arr2[j]){
                long t = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = t;
                i--;
                j++;
            }else{
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

//    def merge(arr1, arr2, n, m):
//        i = n - 1
//        j = 0
//
//        while i >= 0 and j < m:
//            if arr1[i] > arr2[j]:
//                arr1[i], arr2[j] = arr2[j], arr1[i]
//                i -= 1
//                j += 1
//            else:
//                break
//
//        arr1.sort()
//        arr2.sort()

    
}
