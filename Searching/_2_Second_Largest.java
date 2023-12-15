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
    
}
