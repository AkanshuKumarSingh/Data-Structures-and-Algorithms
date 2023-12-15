package Array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class _29_Maximum_of_all_subarrays_of_size_k {


    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
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

	
}
