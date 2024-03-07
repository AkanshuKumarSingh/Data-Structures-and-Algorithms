package Sorting;

import java.util.PriorityQueue;

public class _29_k_largest_elements {

    int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            if(i < k){
                q.offer(arr[i]);
            }else{
                q.offer(arr[i]);
                q.poll();
            }
        }
        
        int ans[] = new int[k];
        for(int i = 0 ; i < k; i++){
            ans[k-1-i] = q.poll();
        }
        
        return ans;
    }
	
}
