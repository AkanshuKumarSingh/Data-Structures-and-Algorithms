package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _8_Number_Of_Provinces {

	static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean vis[] = new boolean[V];
        int cnt = 0;
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                cnt += bfs(i, vis, adj);
            }
        }
        return cnt;
    }
    
    static int bfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;
        
        while(!q.isEmpty()){
            int node = q.remove();
            
            for(int j = 0; j < adj.get(node).size(); j++){
                boolean isEdge = true ? adj.get(node).get(j) == 1 : false;
                if(node != j && isEdge && !vis[j]){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
        return 1;
    }
	
	static class Edge {
		int src;
		int nbr;
		int wt;

		Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static void findAllConnectedComponents(ArrayList<Edge>[] graph, int src, boolean vis[],ArrayList<Integer> list){
		vis[src] = true;
		list.add(src);
		for(Edge n : graph[src]) {
			if(!vis[n.nbr]) {
				findAllConnectedComponents(graph,n.nbr,vis,list);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}

		int edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}

		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

		boolean vis[] = new boolean[vtces];
		for(int i = 0 ; i < vtces; i++) {
			if(!vis[i]) {
				ArrayList<Integer> currComponent = new ArrayList<>();
				findAllConnectedComponents(graph,i,vis,currComponent);
				comps.add(currComponent);
			}
		}

		System.out.println(comps);
	}

}
