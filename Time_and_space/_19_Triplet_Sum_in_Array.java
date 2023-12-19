package Time_and_space;

import java.util.Arrays;

public class _19_Triplet_Sum_in_Array {

    public static boolean find3Numbers(int arr[], int n, int x) { 
        Arrays.sort(arr);
         for(int i = 0; i < n; i++){
             int no = arr[i];
             int l = i+1, r = n-1;
             while(l < r){
                 if(arr[l]+arr[r]+no == x) return true;
                 else if(arr[l]+arr[r]+no < x){
                     l++;
                 }else{
                     r--;
                 }
             }
         }
         return false;
     }
}
