package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class _4_dijkstra {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int dis[] = new int[V];
        boolean visited[] = new boolean[V];
        Arrays.fill(dis, Integer.MAX_VALUE/100);
        dis[S] = 0;
        
        for(int i = 0; i < V-1; i++){
            
            int u = -1;
            for(int j = 0; j < V; j++){
                if(!visited[j] && (u == -1 || dis[u] > dis[i])){
                    u = i;
                }
            }
            
            visited[u] = true;
            ArrayList<ArrayList<Integer>> currArr = adj.get(u);
            for(ArrayList<Integer> a: currArr){
                int v = a.get(0);
                int c = a.get(1);
                
                if(!visited[v]){
                    dis[v] = dis[u] + c;
                }
                
            }
            
        }
        return dis;   
    }
	
    public static class Node implements Comparable<Node>{
        int wt;
        ArrayList<Node> neighbours;
        int idx;
        
        Node(int idx, int wt){
            this.idx = idx;
            this.wt = wt;
            neighbours = new ArrayList<>();
        }

		@Override
		public int compareTo(Node other) {
			return this.wt - other.wt;
		}
        
    }

    
    public static void dijkstra() {
//    	Here's a breakdown of the time complexity:
//
//    	The outer loop runs V times, where V is the number of vertices in the graph. In each iteration, it extracts the node with the minimum distance from the priority queue, which takes O(V) time in the worst case. So, the outer loop contributes O(V^2) time complexity.
//
//    	The inner loop iterates over the adjacent nodes of the current node. In the worst case, it iterates through all the edges of the graph, which can be O(E), where E is the number of edges.
//
//    	Inside the inner loop, there is a constant-time operation (checking and updating distances), so it doesn't significantly affect the overall time complexity.
//
//    	Therefore, the overall time complexity is dominated by the outer loop, resulting in O(V^2) time complexity. This is suitable for small or dense graphs, but for larger or sparser graphs, more efficient data structures like a binary heap or Fibonacci heap should be used to achieve a time complexity of O((V + E) * log(V)).

    	
    	PriorityQueue<Node> q = new PriorityQueue<>();
    	ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
    	int V = 8;
    	int src = 0;
    	int dis[] = new int[V];
    	Arrays.fill(dis, Integer.MAX_VALUE/100);
    	dis[src] = 0;
    	q.offer(new Node(0, 0));
    	
    	while(!q.isEmpty()) {
    		Node curr = q.poll();
    		int v = curr.idx;
    		int wt = curr.wt;
    		
    		for(int i = 0; i < adj.get(v).size(); i++) {
    			int neighIdx = adj.get(v).get(i).get(0);
    			int neighWt = adj.get(v).get(i).get(1);
    			
    			if(dis[neighIdx] > neighWt + wt) {
    				dis[neighIdx] = neighWt + wt;
    				q.offer(new Node(neighIdx, dis[neighIdx]));
    			}
    		}	
    	}	
    }
    
//    import heapq
//
//    class Node:
//        def __init__(self, idx, wt):
//            self.idx = idx
//            self.wt = wt
//
//        def __lt__(self, other):
//            return self.wt < other.wt
//
//    def dijkstra():
//        V = 8
//        src = 0
//
//        # Example Adjacency list: (You need to populate this as per your graph)
//        # Each entry: adj[u] = [[v, weight], [v2, weight2], ...]
//        adj = [[] for _ in range(V)]
//        
//        # Sample graph (you can replace this with actual edges)
//        adj[0].append([1, 4])
//        adj[0].append([7, 8])
//        adj[1].append([0, 4])
//        adj[1].append([2, 8])
//        adj[7].append([0, 8])
//        adj[7].append([6, 1])
//        adj[2].append([1, 8])
//        # Add more as needed...
//
//        dis = [float('inf')] * V
//        dis[src] = 0
//
//        pq = []
//        heapq.heappush(pq, Node(src, 0))
//
//        while pq:
//            curr = heapq.heappop(pq)
//            v = curr.idx
//            wt = curr.wt
//
//            for neighbor in adj[v]:
//                neigh_idx = neighbor[0]
//                neigh_wt = neighbor[1]
//
//                if dis[neigh_idx] > wt + neigh_wt:
//                    dis[neigh_idx] = wt + neigh_wt
//                    heapq.heappush(pq, Node(neigh_idx, dis[neigh_idx]))
//
//        print("Shortest distances from source:")
//        print(dis)

    
    public static void main(String[] args) {
    	
    	
    }
    
    
    
}
