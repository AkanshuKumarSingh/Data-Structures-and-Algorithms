package Sorting;

public class _15_Count_Inversions {

    static long merge(long arr[], long st, long mid, long ed){
        long n1 = mid- st + 1;
        long n2 = ed - mid;
        long inv = 0;
        long t[] = new long[(int) (n1+n2)];
        int i = (int) st;
		int j = (int) (mid+1);
		int k=0;
        while(i <= mid && j <= ed){
            if(arr[i] <= arr[j]){
                t[k++] = arr[i++];
            }else{
                inv += mid-i+1;
                t[k++] = arr[j++];
            }
        }
        
        while(i <= mid){
            t[k++] = arr[i++];
        }
        
        while(j <= ed){
            t[k++] = arr[j++];
        }
        
        k = 0;
        for(i = (int)st; i <= ed; i++){
            arr[i] = t[k++];
        }
        
        return inv;
    }
    
    static long mergeSort(long arr[], long st, long ed){
        if(st >= ed) return 0;
        
        long mid = st + (ed-st)/2;
        long inv = mergeSort(arr, st, mid);
        inv += mergeSort(arr, mid+1, ed);
        inv += merge(arr, st, mid, ed);
        return inv;
    }
    
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        return mergeSort(arr, 0, N-1);
    }
	


}
