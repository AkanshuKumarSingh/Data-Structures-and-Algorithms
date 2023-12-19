package Time_and_space;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _38_Sorting_Elements_of_an_Array_by_Frequency {

    static class Node implements Comparable<Node>{
		int no;
		int time;
		Node(int no, int time){
			this.no = no;
			this.time = time;
		}
		
		public int compareTo(Node node) {
		    if(this.time-node.time == 0){
		        if(this.no < node.no){
		            return -1;
		        }else{
		            return 1;
		        }
		    }
			return -(this.time-node.time);
		}
		
	}

    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
//      System.out.println("HHM");
        Map<Integer,Integer> map = new HashMap<>();
    	ArrayList<Integer> list = new ArrayList<>();
    	for(int i : arr) {
    		if(!map.containsKey(i)) {
    			map.put(i, 1);
    		}else {
    			map.put(i, map.get(i)+1);
    		}
    	}
    	PriorityQueue<Node> queue = new PriorityQueue<>();
    	for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
    		queue.add(new Node(entry.getKey(),entry.getValue()));
    	}
    	while(!queue.isEmpty()) {
    		Node node = queue.remove();
    		for(int i = 0 ; i < node.time; i++) {
    			list.add(node.no);
    		}
    	}
    	return list;
        
    }
	
}
