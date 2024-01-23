package Heap;

import java.util.PriorityQueue;

public class _6_Kth_largest_element_in_stream {

    static int[] kthLargest(int k, int[] arr, int n) {
        int ans[] = new int[n];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0 ; i < n ; i++){
            if(i < k){
                q.offer(arr[i]);
            }else if(q.peek() < arr[i]){
                q.poll();
                q.offer(arr[i]);
            }
            
            if(i < k-1) ans[i] = -1;
            else ans[i] = q.peek();
        }
        return ans;
    }
	
}
