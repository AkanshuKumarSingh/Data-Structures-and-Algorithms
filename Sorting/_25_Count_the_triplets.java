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
	
}
