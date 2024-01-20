package Hashing;

import java.util.*;

public class _19_Find_all_pairs_with_given_sum {

	static class pair  {  
	    long first, second;  
	    public pair(long first, long second)  
	    {  
	        this.first = first;  
	        this.second = second;  
	    }  
	}
	
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        Arrays.sort(A);
        ArrayList<pair> ans = new ArrayList<>();
        
        HashSet<Long> set = new HashSet<>();
        for(long no : B){
            set.add(no);
        }
        
        for(long no : A){
            if(set.contains(X-no)){
                ans.add(new pair(no, X-no));
            }
        }
        
        pair arr[] = new pair[ans.size()];
        ans.toArray(arr);
        return arr;
    }
	
}
