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

//      n = len(arr)
//	    lmax = [0] * n
//	    rmax = [0] * n
//
//	    # Initialize lmax and rmax
//	    lmax[0] = arr[0]
//	    rmax[n - 1] = arr[n - 1]
//
//	    # Fill lmax and rmax arrays
//	    for i in range(1, n):
//	        lmax[i] = max(lmax[i - 1], arr[i])
//	        rmax[n - 1 - i] = max(rmax[n - i], arr[n - 1 - i])
//
//	    # Calculate trapped water
//	    water = 0
//	    for i in range(n):
//	        water += min(lmax[i], rmax[i]) - arr[i]
//
//	    return water        

    } 
	
}
