package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _41_Cheapest_Flights_Within_K_Stops {
	
//	0 -> [(1, 10), (2, 50)] ans not working in below test case but this test case is not in leetcode, made by me
//			1 -> [(2, 10)]
//			2 -> [(4, 60)]
//			4 -> [(5, 50)]

    static class Node implements Comparable<Node>{
        int n;
        int wt;
        int k;
        
        Node(int n, int wt, int k){
            this.n = n;
            this.wt = wt;
            this.k = k;
        }

        public int compareTo(Node oth){
            return this.wt - oth.wt;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList <ArrayList<ArrayList <Integer>>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int flight[]: flights){
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(v);
            curr.add(price);
            adj.get(u).add(curr);
        }

        Queue<Node> q = new LinkedList<>();
        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        q.add(new Node(src, 0, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.k > k) continue;
            for(ArrayList<Integer> curr: adj.get(node.n)){
                int neigh = curr.get(0);
                int wt = curr.get(1);
                if(wt + node.wt < dis[neigh] && node.k <= k){
                    dis[neigh] = node.wt + wt;
                    q.offer(new Node(neigh, node.wt+wt, node.k + 1));    
                }
            }
        }
        return dis[dst] != Integer.MAX_VALUE ? dis[dst] : -1;
    }
	
}
