package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _11_Queue_Reversal {

    public Queue<Integer> rev(Queue<Integer> q){
        Queue<Integer> ans = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()){
            st.push(q.poll());
        }
        
        while(!st.isEmpty()){
            ans.offer(st.pop());
        }
        
        return ans;
    }

	
}
