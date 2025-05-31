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
    
//    def min_jumps(arr):
//        n = len(arr)
//
//        if n <= 1:
//            return 0
//        elif arr[0] == 0:
//            return -1
//        elif arr[0] >= n - 1:
//            return 1
//
//        jumps = 1
//        max_reach = arr[0]
//        step = arr[0]
//
//        for i in range(1, n):
//            max_reach = max(max_reach, i + arr[i])
//            step -= 1
//
//            if step == 0:
//                jumps += 1
//                step = max_reach - i
//
//                if max_reach >= n - 1:
//                    return jumps
//                elif i >= max_reach:
//                    return -1
//
//        return -1
    

}
