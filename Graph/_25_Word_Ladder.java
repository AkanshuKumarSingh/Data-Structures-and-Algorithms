package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _25_Word_Ladder {
	
	   public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        HashSet<String> not_vis = new HashSet<>(wordList);
	        Queue<String> q = new LinkedList<>();
	        q.add(beginWord);
	        int neigh_cnt = 1;

	        while(!q.isEmpty()){
	            int sz = q.size();
	            while(sz-- > 0){
	                String curr = q.remove();
	                if(curr.equals(endWord)){
	                    return neigh_cnt;
	                }
	                for(int i = 0; i < curr.length(); i++){
	                    for(int j = 'a'; j <= 'z'; j++){
	                        char newWordArr[] = curr.toCharArray();
	                        newWordArr[i] = (char)j;
	                        String newWord = new String(newWordArr);
	                        if(not_vis.contains(newWord)){
	                            q.add(newWord);
	                            not_vis.remove(newWord);
	                        }
	                    }
	                }
	            }
	            neigh_cnt++;
	        }
	        return 0;
	    }
	
}
