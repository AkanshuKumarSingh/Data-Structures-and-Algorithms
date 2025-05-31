package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _1_BFS {
	
    //GFG Function to return Breadth First Traversal of given graph.
	public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean isVisited[] = new boolean[V];
        q.add(0);
        isVisited[0] = true;
        
        while(!q.isEmpty()){
            int v = q.remove();
            ans.add(v);
            for(int i: adj.get(v)){
                if(!isVisited[i]){
                    q.add(i);
                    isVisited[i] = true;
                }
            }
        }
        
        return ans;
//        Time Complexity: O(V+E), where V is the number of nodes and E is the number of edges.
//        Outer while loop:
//        	The while loop runs until the queue becomes empty. Every vertex is enqueued and dequeued exactly once, so the 
//        	loop runs O(V) times (where V is the number of vertices).
//    	  Inner for loop:
//        	For each vertex, the inner for loop iterates over all its adjacent vertices. Across all vertices, 
//        	this loop will run O(E) times (where E is the number of edges), since each edge is considered exactly once.
//
//        	Adding an edge to the queue and marking it visited takes O(1).
//        Auxiliary Space: O(V)

    }
	
//	from collections import deque
//
//	def bfs_of_graph(V, adj):
//	    q = deque()
//	    ans = []
//	    is_visited = [False] * V
//
//	    q.append(0)
//	    is_visited[0] = True
//
//	    while q:
//	        v = q.popleft()
//	        ans.append(v)
//
//	        for i in adj[v]:
//	            if not is_visited[i]:
//	                q.append(i)
//	                is_visited[i] = True
//
//	    return ans

	
    //GFG Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph_1(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean isVisited[] = new boolean[V];
        q.add(0);

        while(!q.isEmpty()){
            int v = q.remove();
            
            if(!isVisited[v]){
                ans.add(v);
                isVisited[v] = true;
                
                for(int i: adj.get(v)){
                    if(!isVisited[i]){
                        q.add(i);
                    }
                }
                
            }
        }
        
        return ans;
    }

	
	public static class BFSPair {
		int src;
		String psf;

		public BFSPair(int src, String psf) {
			this.src = src;
			this.psf = psf;
		}
	}

	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	public static void bfs(ArrayList<Edge> graph[], int src) {
		Queue<BFSPair> qu = new LinkedList<>();

		qu.add(new BFSPair(src, "" + src));
		boolean[] vis = new boolean[graph.length];

		while (!qu.isEmpty()) {

			//1. get + remove 
			BFSPair rem = qu.remove();

			//2. mark *
			if (!vis[rem.src]) {
				continue;
			}
			
			vis[rem.src] = true;
			
			//3. work -> print src@psf
			System.out.println(rem.src + "@" + rem.psf);
			
			// add unvisited neighbor
			for(Edge e : graph[rem.src]) {
				int nbr = e.nbr;
				if(!vis[nbr]) {
					qu.add(new BFSPair(nbr,rem.psf+nbr));
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
