package Array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _29_Maximum_of_all_subarrays_of_size_k {


    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
    	
    	// 1st way
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deq = new LinkedList<>();
        int i;
        
        for(i = 0 ; i < k ; i++){
            while(!deq.isEmpty() && arr[i] > arr[deq.peekLast()]){
                deq.removeLast();
            }
            deq.addLast(i);
        }
        
        for(;i < n; i++){
            int firstIndex = deq.peekFirst();
            list.add(firstIndex);
            while(!deq.isEmpty() && arr[i] > arr[deq.peekLast()]){
                deq.removeLast();
            }
            if(i-k >= firstIndex && !deq.isEmpty()){
                deq.removeFirst();
            }
            deq.addLast(i);
        }
        
        list.add(deq.peekFirst());
        
        for(i = 0; i < list.size(); i++){
            list.set(i, arr[list.get(i)]);
        }
        
        return list;
    }

    static ArrayList <Integer> max_of_subarrays1(int arr[], int n, int k)
    {
    	//2nd way
		int nge[] = new int[n];
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
				nge[st.pop()] = i;
			}
			st.push(i);
		}

		while (!st.isEmpty()) {
			nge[st.pop()] = n;
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0 ; i <= n-k; i++){
		    ans.add(0);
		}
		
		int j = 0;
		for(int i = 0; i <= n-k; i++){
		    if(j < i) j = i;
		    while(nge[j] < i+k){
		        j = nge[j];
		    }
		    ans.set(i, arr[j]);
		}
		
		return ans;
		

//		def max_in_windows(arr, n, k):
//		    nge = [0] * n
//		    stack = []
//
//		    # Build the NGE array
//		    for i in range(n):
//		        while stack and arr[i] > arr[stack[-1]]:
//		            nge[stack.pop()] = i
//		        stack.append(i)
//
//		    while stack:
//		        nge[stack.pop()] = n
//
//		    # Initialize result array
//		    ans = [0] * (n - k + 1)
//
//		    j = 0
//		    for i in range(n - k + 1):
//		        if j < i:
//		            j = i
//		        while nge[j] < i + k:
//		            j = nge[j]
//		        ans[i] = arr[j]
//
//		    return ans
		
		
//		python code
//	    n = len(arr)
//	    nge = [0] * n
//	    stack = deque()
//	    
//	    for i in range(n):
//	        while stack and arr[i] > arr[stack[-1]]:
//	            nge[stack.pop()] = i
//	        stack.append(i)
//	    
//	    while stack:
//	        nge[stack.pop()] = n
//	    
//	    ans = [0] * (n - k + 1)
//	    j = 0
//	    for i in range(n - k + 1):
//	        if j <= i:
//	            j = i
//	        while nge[j] < i + k:
//	            j = nge[j]
//	        ans[i] = arr[j]
//	    
//	    return ans
    }

	
}
