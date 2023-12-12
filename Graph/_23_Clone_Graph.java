package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _23_Clone_Graph {
	
    static class Node{
        int val;
        ArrayList<Node> neighbors;
        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }
    
        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }
    
        public Node(int val, ArrayList<Node> neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    Node cloneGraph(Node node){
        HashMap<Integer, Node> map = new HashMap<>();
        Node curr = new Node(node.val);
        map.put(node.val, curr);
        Queue<Node> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        q.add(node);

        while(!q.isEmpty()){
            curr = q.remove();
            Node copyCurr = map.get(curr.val);
            
            if(vis.contains(curr.val)){
                continue;
            }
            
            vis.add(curr.val);
            for(Node neigh: curr.neighbors){
                Node copyNeigh;
                if(map.containsKey(neigh.val)){
                    copyNeigh = map.get(neigh.val);
                }else{
                    copyNeigh = new Node(curr.val);
                    map.put(neigh.val, copyNeigh);
                }
                copyCurr.neighbors.add(copyNeigh);
                q.add(neigh);
            }
        }
        
        return map.get(node.val);
            
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
