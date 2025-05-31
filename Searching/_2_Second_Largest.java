package Searching;

public class _2_Second_Largest {

    int print2largest(int arr[], int n) {
        int max = -1, secondMax = -1;
        
        for(int i = 0 ; i < n; i++){
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }else if(arr[i] > secondMax && arr[i] != max){
                secondMax = arr[i];
            }
        }
        
        return secondMax;
    }

//    def print_2_largest(arr, n):
//        max_val = -1
//        second_max = -1
//
//        for i in range(n):
//            if arr[i] > max_val:
//                second_max = max_val
//                max_val = arr[i]
//            elif arr[i] > second_max and arr[i] != max_val:
//                second_max = arr[i]
//
//        return second_max    

}
