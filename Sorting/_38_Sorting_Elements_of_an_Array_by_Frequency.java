package Sorting;

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
	
//    from typing import List
//    from collections import Counter
//    import heapq
//
//    class Node:
//        def __init__(self, no, time):
//            self.no = no
//            self.time = time
//
//        def __lt__(self, other):
//            # For max-heap: higher frequency first, and then lower number
//            if self.time == other.time:
//                return self.no < other.no
//            return self.time > other.time
//
//    def sortByFreq(arr: List[int], n: int) -> List[int]:
//        freq_map = Counter(arr)
//        heap = []
//
//        for number, freq in freq_map.items():
//            heapq.heappush(heap, Node(number, freq))
//        
//        result = []
//        while heap:
//            node = heapq.heappop(heap)
//            result.extend([node.no] * node.time)
//        
//        return result

    
}
