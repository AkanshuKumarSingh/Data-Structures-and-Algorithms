package Heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _12_Game_with_String {

    static int minValue(String str, int k){
	    HashMap<Character, Integer> map = new HashMap<>();
	    for(int i = 0 ; i < str.length(); i++){
	        char ch = str.charAt(i);
	        int curr = map.getOrDefault(ch, 0);
	        curr++;
	        map.put(ch, curr);
	    }
	    
	    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
	    q.addAll(map.values());
	    int ans = 0;
	    while(!q.isEmpty() && k-- > 0){
	        int curr = q.poll();
	        curr--;
	        if(curr > 0)
                q.offer(curr);          
	    }
	    
	    while(!q.isEmpty()){
	        int curr = q.poll();
	        ans += (curr*curr);
	    }
	    return ans;
    }
	
}
