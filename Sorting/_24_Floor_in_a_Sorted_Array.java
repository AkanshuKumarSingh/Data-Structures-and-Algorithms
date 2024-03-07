package Sorting;

public class _24_Floor_in_a_Sorted_Array {
	
    static int findFloor(long arr[], int n, long x)
    {
        int i = 0, j = n-1, k = -1;
        while(i <= j){
            int m = i + (j-i)/2;
            if(arr[m] == x){
                return m;
            }else if(arr[m] < x){
                k = m;
                i = m+1;
            }else{
                j = m-1;
            }
        }
        return k;
    }
    
}
