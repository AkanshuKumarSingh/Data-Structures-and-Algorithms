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
    }
	
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
