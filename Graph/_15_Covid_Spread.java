package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _15_Covid_Spread {

	// Leetcode
    static class Node{
        int i, j, t;

        Node(int i, int j, int t){
            this.i = i;
            this.j = j;
            this.t = t;
        }

        Node(int i, int j){
            this.i = i;
            this.j = j;
        }
        
    }

	
    public int helpaterp(int[][] hospital) {
        int time = 0;
        int uninfected = 0;
        Queue<Node> q = new LinkedList<>();
        
        for(int i = 0; i < hospital.length; i++){
            for(int j = 0; j < hospital[i].length; j++){
                if(hospital[i][j] == 2){
                    q.add(new Node(i,j,0));            
                }else if(hospital[i][j] == 1){
                    uninfected += 1;
                }
            }
        }        
        

        while(!q.isEmpty()){
            Node node = q.remove();
            int i = node.i;
            int j = node.j;
            int t = node.t;
            time = Math.max(t, time);

            if(i > 0 && hospital[i][j] == 2 && hospital[i-1][j] == 1){
                q.add(new Node(i-1,j, t+1));
                hospital[i-1][j] = 2;
                uninfected -= 1;
            }
            if(i < hospital.length-1 && hospital[i][j] == 2 && hospital[i+1][j] == 1){
                q.add(new Node(i+1,j, t+1));
                hospital[i+1][j] = 2;
                uninfected -= 1;
            }
            if(j > 0 && hospital[i][j] == 2 && hospital[i][j-1] == 1){
                q.add(new Node(i, j-1, t+1));
                hospital[i][j-1] = 2;
                uninfected -= 1;
            }
            if(j < hospital[i].length-1 && hospital[i][j] == 2 && hospital[i][j+1] == 1){
                q.add(new Node(i, j+1, t+1));
                hospital[i][j+1] = 2;
                uninfected -= 1;
            }
            
        }
        
        return uninfected == 0 ? time: -1;
    }

	
	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	static class Pair {
		int src;
		int time;

		Pair(int src, int time) {
			this.src = src;
			this.time = time;
		}
	}

	public static int spreadOfInfection(ArrayList<Edge>[] graph, int src, int t) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(src, 1));
		boolean vis[] = new boolean[graph.length];
		int count = 0;

		while (!q.isEmpty()) {
			Pair rem = q.poll();

			if (vis[rem.src]) {
				continue;
			}
			vis[rem.src] = true;
			if (rem.time == t+1) {
				break;
			}
			count++;

			for (Edge e : graph[rem.src]) {
				if (!vis[e.nbr]) {
					q.offer(new Pair(e.nbr, rem.time + 1));
				}
			}
		}

		return count;
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
			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
		}

		int src = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());

		System.out.println(spreadOfInfection(graph, src, t));

	}
}
