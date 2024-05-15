package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _16_Network_delay_time {

	static class Node implements Comparable<Node> {
		int n;
		int wt;
		ArrayList<Node> neighs;
		ArrayList<Integer> weights;

		Node(int n, int wt) {
			this.n = n;
			this.wt = wt;
			neighs = new ArrayList<>();
			weights = new ArrayList<>();
		}

		@Override
		public int compareTo(Node oth) {
			return this.wt - oth.wt;
		}

	}

	public int networkDelayTime(int[][] times, int n, int k) {

		HashMap<Integer, Node> map = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			map.put(i, new Node(i, 0));
		}

		for (int i = 0; i < times.length; i++) {
			int src = times[i][0];
			int des = times[i][1];
			int wt = times[i][2];
			map.get(src).neighs.add(map.get(des));
			map.get(src).weights.add(wt);
		}

		int dis[] = new int[n + 1];
		boolean vis[] = new boolean[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE / 100);

		dis[k] = 0;
		PriorityQueue<Node> q = new PriorityQueue<>();
		Node curr = map.get(k);
		q.add(curr);
		int time = -1;

		while (!q.isEmpty()) {
			curr = q.poll();
			vis[curr.n] = true;

			for (int i = 0; i < map.get(curr.n).neighs.size(); i++) {
				Node neigh = map.get(curr.n).neighs.get(i);
				int wt = map.get(curr.n).weights.get(i);
				if (!vis[neigh.n] && dis[neigh.n] > dis[curr.n] + wt) {
					dis[neigh.n] = dis[curr.n] + wt;
					neigh.wt = dis[curr.n] + wt;
					q.offer(neigh);
				}
			}

		}

		for (int i = 1; i <= n; i++) {
			time = Math.max(time, dis[i]);
		}
		return time == Integer.MAX_VALUE / 100 ? -1 : time;
	}

}
