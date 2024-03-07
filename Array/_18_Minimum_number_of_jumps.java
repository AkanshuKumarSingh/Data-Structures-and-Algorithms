package Array;

public class _18_Minimum_number_of_jumps {
	
    static int minJumps(int[] arr){
    	int jumps = 1;
    	int maxReach = arr[0];
    	int step = arr[0];
    	
    	if(arr.length <= 1){
    	    return 0;
    	}else if(arr[0] == 0) {
    		return -1;
    	}else if(arr[0] >= arr.length-1) {
    		return 1;
    	}
    	
    	for(int i = 1 ; i < arr.length; i++) {
    		
    		// In jump ith we are calculation how far we can reach in (i+1)th jump
    		maxReach = Math.max(maxReach, i+arr[i]);
    		step--;
    		
    		if(step == 0) {
    			jumps++;
    			step = maxReach - i;
    			// Now when steps of ith jump are exhausted calculate if in i+1 th jump we can reach end or not
    			if(maxReach >= arr.length-1) {
    				return jumps;
    			}else if(i > maxReach) {
    				return -1;
    			}
    		}

    	}
    	
    	return -1;
    }
}
