package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _18_prims {

    
    static class Node implements Comparable<Node>{
        int wt;
        int no;
        
        Node(int no, int wt){
            this.no = no;
            this.wt = wt;
        }
        
        public int compareTo(Node oth){
            return this.wt - oth.wt;
        }
        
    }
    
	static int spanningTree(int V, int E, int edges[][]){

	    PriorityQueue<Node> q = new PriorityQueue<>();
	    boolean vis[] = new boolean[V];
	    int dis[] = new int[V];
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i = 0; i < V; i++){
            list.add(new ArrayList<Node>());
        }
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
	    
	    for(int i = 0; i < edges.length; i++){
	        int v1 = edges[i][0];
	        int v2 = edges[i][1];
    	    int wt = edges[i][2];
            list.get(v1).add(new Node(v2, wt));
            list.get(v2).add(new Node(v1, wt));
	    }
        
        q.offer(new Node(0, 0));
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(vis[curr.no]){
                continue;
            }
            
            vis[curr.no] = true;
            for(int i = 0; i < list.get(curr.no).size(); i++){
                Node neigh = list.get(curr.no).get(i);
                int v = neigh.no;
                int wt = neigh.wt;
                
                if(!vis[neigh.no] && dis[neigh.no] > wt){
                    dis[neigh.no] = wt;
                    q.offer(new Node(v, wt));
                }
            }
            
        }
    
        int ans = 0;
        for(int i : dis){
            ans += i;
        }
        
        return ans;
	}

	
//	  Check it
//    static class Node implements Comparable<Node>{
//        int wt;
//        int no;
//        ArrayList<Node> neighs;
//        ArrayList<Integer> weights;
//        
//        Node(int no, int wt){
//            this.no = no;
//            this.wt = wt;
//            neighs = new ArrayList<>();
//            weights = new ArrayList<>();
//        }
//        
//        public int compareTo(Node oth){
//            return this.wt - oth.wt;
//        }
//        
//    }
//    
//	static int spanningTree(int V, int E, int edges[][]){
//	    ArrayList<Node> nodes = new ArrayList<>();
//	    PriorityQueue<Node> q = new PriorityQueue<>();
//	    boolean vis[] = new boolean[V];
//	    int dis[] = new int[V];
//        Arrays.fill(dis, Integer.MAX_VALUE);
//	    
//	    for(int i = 0; i < V; i++){
//	        nodes.add(new Node(i, 0));
//	    }
//	    
//	    for(int i = 0; i < edges.length; i++){
//	        int v1 = edges[i][0];
//	        int v2 = edges[i][1];
//    	    int wt = edges[i][2];
//	        Node n1 = nodes.get(v1);
//	        Node n2 = nodes.get(v2);
//	        n1.neighs.add(n2);
//	        n1.weights.add(wt);
//	        n2.neighs.add(n1);
//	        n2.weights.add(wt);
//	    }
//        
//        Node curr = nodes.get(0);
//        dis[0] = 0;
//        q.offer(curr);
//        
//        while(!q.isEmpty()){
//            curr = q.poll();
//            if(vis[curr.no]){
//                continue;
//            }
//            
//            vis[curr.no] = true;
//            for(int i = 0; i < curr.neighs.size(); i++){
//                Node neigh = curr.neighs.get(i);
//                int wt = curr.weights.get(i);
//                
//                if(!vis[neigh.no] && dis[neigh.no] > wt){
//                    dis[neigh.no] = wt;
//                    neigh.wt = wt;
//                    q.offer(neigh);
//                }
//            }
//            
//        }
//    
//        int ans = 0;
//        for(int i : dis){
//            ans += i;
//        }
//        
//        return ans;
//	}

}