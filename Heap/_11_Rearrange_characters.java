package Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class _11_Rearrange_characters {

    static class Node implements Comparable<Node>{
        int freq;
        char ch;
        
        Node(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
        
        public int compareTo(Node node){
            return node.freq-this.freq;
        }
        
    }
    
	public static String rearrangeCharacters(String str) {
	    HashMap<Character, Node> map = new HashMap<>();
	    for(int i = 0 ; i < str.length(); i++){
	        char ch = str.charAt(i);
	        Node curr = map.getOrDefault(ch, new Node(ch, 0));
	        curr.freq++;
	        map.put(ch, curr);
	    }
	    
	    PriorityQueue<Node> q = new PriorityQueue<>(map.values());
	    StringBuilder ans = new StringBuilder();
	    Node prev = null;
	    
	    while(!q.isEmpty()){
	        Node curr = q.poll();
	        ans.append(curr.ch);
	        curr.freq--;
	        
	        
	        if(prev != null && prev.freq > 0){
	            q.offer(prev);
	        }
	        
	        prev = curr;
	        if(q.isEmpty() && prev.freq > 1) return "-1";
	        if(q.size() == 1 && q.peek().freq > 1 && prev.freq == 0) return "-1";
	    }
	    
	    
	    
	    // System.out.println(ans.toString());
	    return ans.toString();
	}
	
}
