package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _10_Perfect_Friends {

//	1. You are given a number n (representing the number of students). Each student will have an id 
//    from 0 to n - 1.
//  2. You are given a number k (representing the number of clubs)
//  3. In the next k lines, two numbers are given separated by a space. The numbers are ids of 
//    students belonging to same club.
//  4. You have to find in how many ways can we select a pair of students such that both students are 
//    from different clubs.

	
	static int cnt = 0;

	public static void visitItMine(ArrayList<Integer> graph[], int src, boolean vis[]) {
		cnt++;
		vis[src] = true;
		for (int nodes : graph[src]) {
			if (!vis[nodes]) {
				visitItMine(graph, nodes, vis);
			}
		}
	}

	public static int countPairMine(ArrayList<Integer> graph[], boolean vis[]) {
		ArrayList<Integer> list = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < vis.length; i++) {
			if (!vis[i]) {
				visitItMine(graph, i, vis);
				list.add(cnt);
				sum += cnt;
				cnt = 0;
			}
		}

		System.out.println(list);
		int ans = 0;
		for (int i = 0; i < list.size(); i++) {
			sum -= list.get(i);
			ans += (list.get(i) * sum);
		}

		return ans;
	}

	public static void gcc(ArrayList<Integer> graph[], int src, boolean vis[], ArrayList<Integer> comps) {
		vis[src] = true;
		comps.add(src);
		for (int nodes : graph[src]) {
			if (!vis[nodes]) {
				gcc(graph, nodes, vis, comps);
			}
		}
	}

	public static int countPair(ArrayList<Integer> graph[], boolean vis[]) {
		ArrayList<ArrayList<Integer>> components = new ArrayList<>();
		for (int i = 0; i < vis.length; i++) {
			if (!vis[i]) {
				ArrayList<Integer> comps = new ArrayList<>();
				gcc(graph, i, vis, comps);
				components.add(comps);
			}
		}

		int sum = 0;
		int ans = 0;
		for (int i = components.size() - 1; i >= 0; i--) {
			int sz = components.get(i).size();
			ans += (sz*sum);
			sum += sz;
		}

		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> graph[] = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		boolean vis[] = new boolean[n];

		int edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			String str[] = br.readLine().trim().split(" ");
			int st = Integer.parseInt(str[0]);
			int des = Integer.parseInt(str[1]);

			graph[st].add(des);
			graph[des].add(st);
		}

		int res = countPairMine(graph, vis);
		System.out.println(res);
	}

}
