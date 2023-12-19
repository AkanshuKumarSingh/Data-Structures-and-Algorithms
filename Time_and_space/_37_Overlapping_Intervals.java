package Time_and_space;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class _37_Overlapping_Intervals {

	public static class Pair implements Comparable<Pair> {
		int st;
		int end;

		public Pair(int st, int end) {
			this.st = st;
			this.end = end;
		}

		public int compareTo(Pair other) {
			return this.st - other.st;
		}

	}
	
    public int[][] overlappedInterval(int[][] arr)
    {
        ArrayList<Pair> pairs = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        int n = arr.length;
        for(int i = 0 ; i < n ; i++){
            pairs.add(new Pair(arr[i][0],arr[i][1]));    
        }
        Collections.sort(pairs);
        st.push(pairs.get(0));
        for(int i = 1; i < pairs.size(); i++){
            Pair p = pairs.get(i);
            if(st.peek().end < p.st){
                st.push(p);
            }else{
                st.peek().end = Math.max(st.peek().end, p.end);
            }
        }
        
        int ans[][] = new int[st.size()][2], i = st.size()-1;
        while(!st.isEmpty()){
            Pair p = st.pop();
            ans[i][0] = p.st;
            ans[i][1] = p.end;
            i--;
        }
        
        return ans;
    }
	
}
