package Sorting;

import java.util.Arrays;

public class _27_Find_Pair_Given_Difference {

    public boolean findPair(int arr[], int size, int n)
    {
        Arrays.sort(arr);
        for(int i = 0; i < size; i++){
            int no = arr[i] + n;
            int x = i+1, y = size-1;
            while(x <= y){
                int m = x + (y-x)/2;
                if(arr[m] == no){
                    return true;
                }else if(arr[m] < no){
                    x = m+1;
                }else{
                    y = m-1;
                }
            }
        }
        return false;
    }

//    def find_pair(arr, n):
//        arr.sort()
//        size = len(arr)
//        for i in range(size):
//            target = arr[i] + n
//            x, y = i + 1, size - 1
//            while x <= y:
//                m = x + (y - x) // 2
//                if arr[m] == target:
//                    return True
//                elif arr[m] < target:
//                    x = m + 1
//                else:
//                    y = m - 1
//        return False

    
}
