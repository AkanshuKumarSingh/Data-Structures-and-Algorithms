package Sorting;

public class _14_Kth_smallest_element {

    public static int partIndex(int arr[], int l, int r){
        int i = l, j = l;
        while(i <= r){
            if(arr[i] <= arr[r]){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j++;
            }else{
                i++;
            }
        }
        
        return j-1;
    }
    
    public static int kthSmallest(int[] arr, int l, int r, int k) { 
        int idx = partIndex(arr, l, r);
        if(idx + 1 == k){
            return arr[idx];
        }else if(idx + 1 < k){
            return kthSmallest(arr, idx+1, r, k);
        }else{
            return kthSmallest(arr, l, idx-1, k);
        }
    }
	
}
