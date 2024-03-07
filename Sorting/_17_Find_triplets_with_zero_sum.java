package Sorting;

import java.util.Arrays;

public class _17_Find_triplets_with_zero_sum {

	public boolean findTriplets(int arr[] , int n)
    {
        Arrays.sort(arr);
        
        for(int i = 0; i < n; i++){
            int no = arr[i];
            int l = i+1, r = n-1;
            while(l < r){
                if(arr[l]+arr[r]+no == 0) return true;
                else if(arr[l]+arr[r]+no < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return false;
    }
	
}
