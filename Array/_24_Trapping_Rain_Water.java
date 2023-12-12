package Array;

public class _24_Trapping_Rain_Water {

    static long trappingWater(int arr[], int n) { 
        
        long lmax[] = new long[n];
        long rmax[] = new long[n];
        lmax[0] = arr[0];
        rmax[n-1] = arr[n-1];
        
        for(int i = 1 ; i < n ; i++){
            lmax[i] = Math.max(lmax[i-1], arr[i]);
            rmax[n-1-i] = Math.max(rmax[n-i], arr[n-1-i]);
        }
        
        long water = 0;
        for(int i = 0 ; i < n ; i++){
            water += (Math.min(lmax[i],rmax[i]) - arr[i]);
        }
        
        return water;
    } 
	
}
