package Array;

public class _15_Kadanes_Algorithm {

	public static void main(String[] args) 
    {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Maximum contiguous sum is " + maxSubArraySumPrint(a));
    }
 
    // Function Call
    long maxSubArraySum1(int a[])
    {
        int size = a.length;
        long max_so_far = Integer.MIN_VALUE, sum = 0;
        for(int i = 0 ; i < a.length; i++) {
        	sum  = sum + a[i];
        	max_so_far = Math.max(max_so_far, sum);
        	sum = sum < 0 ? 0:sum;
        }
        return max_so_far;

//      python code
//      max_so_far = float('-inf')
//	    sum_so_far = 0
//	    
//	    for num in arr:
//	        sum_so_far += num
//	        max_so_far = max(max_so_far, sum_so_far)
//	        sum_so_far = max(0, sum_so_far)

    }

    long maxSubarraySum(int arr[], int n){
        long currAns = 0, maxAns = Integer.MIN_VALUE;
        int st = 0, ed = 0;
        for(int i = 0 ; i < n; i++){
            currAns += arr[i];
            maxAns = Math.max(maxAns, currAns);
            if(currAns < 0){
                currAns = 0;
                st = i+1;
            }else{
                ed = i;
            }
        }
        return maxAns;
    }
    
    // Also print that arr
    static int maxSubArraySumPrint(int a[])
    {
        int size = a.length, stAns = 0, endAns = 0, stCurr = 0;
        int maxAns = Integer.MIN_VALUE, maxSoFar = 0;
        for(int i = 0 ; i < a.length; i++) {
        	maxSoFar  = maxSoFar + a[i];
        	if(maxSoFar > maxAns) {
        		maxAns = maxSoFar;
        		stAns = stCurr;
        		endAns = i;
        	}
        	
        	if(maxSoFar < 0) {
        		maxSoFar = 0;
        		stCurr = i+1;
        	}
        	
        }
        System.out.println(stAns + ":" + endAns);
        return maxAns;
    }
    
//    def max_sub_array_sum_print(a):
//        size = len(a)
//        st_ans = 0
//        end_ans = 0
//        st_curr = 0
//        max_ans = float('-inf')
//        max_so_far = 0
//
//        for i in range(size):
//            max_so_far += a[i]
//            
//            if max_so_far > max_ans:
//                max_ans = max_so_far
//                st_ans = st_curr
//                end_ans = i
//
//            if max_so_far < 0:
//                max_so_far = 0
//                st_curr = i + 1
//
//        print(f"{st_ans}:{end_ans}")
//        return max_ans

    
}
