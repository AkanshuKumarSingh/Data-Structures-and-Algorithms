package Searching;

public class _1_binary_search {

//	def binary_search(arr, x):
//	    low = 0
//	    high = len(arr) - 1
//	
//	    while low <= high:
//	        mid = low + (high - low) // 2
//	
//	        # Check if x is present at mid
//	        if arr[mid] == x:
//	            return mid
//	
//	        # If x greater, ignore left half
//	        elif arr[mid] < x:
//	            low = mid + 1
//	
//	        # If x is smaller, ignore right half
//	        else:
//	            high = mid - 1
//	
//	    # Element not 
	
    int binarySearch(int arr[], int x)
    {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int m = low + (high - low) / 2;
 
            // Check if x is present at mid
            if (arr[m] == x)
                return m;
 
            // If x greater, ignore left half
            if (arr[m] < x)
                low = m + 1;
 
            // If x is smaller, ignore right half
            else
                high = m - 1;
        }
 
        // If we reach here, then element was
        // not present
        return -1;
    }

	
}
