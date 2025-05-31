package Searching;

public class _5_Smallest_Positive_missing_number {

    static int missingNumber(int arr[], int n)
    {
        
        for(int i = 0 ; i < n; i++){
            while(arr[i] > 0 && arr[i] < n && arr[i] != arr[arr[i] - 1]){
                int t = arr[i];
                arr[i] = arr[t-1];
                arr[t-1] = t;
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] != i+1){
                return i+1;
            }
        }
        
        return n+1;
    }

//    def missing_number(arr, n):
//        for i in range(n):
//            while 0 < arr[i] < n and arr[i] != arr[arr[i] - 1]:
//                t = arr[i]
//                arr[i], arr[t - 1] = arr[t - 1], arr[i]
//
//        for i in range(n):
//            if arr[i] != i + 1:
//                return i + 1
//
//        return n + 1

}
