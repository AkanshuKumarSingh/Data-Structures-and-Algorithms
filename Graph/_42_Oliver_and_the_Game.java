package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _42_Oliver_and_the_Game {

	static int inTime[];
	static int outTime[];
	static int timer;

	public static void preprocess(int node, ArrayList<ArrayList<Integer>> adj) {
		inTime[node] = timer++;
		for (int neigh : adj.get(node)) {
			if (inTime[neigh] == -1) {
				preprocess(neigh, adj);
			}
		}
		outTime[node] = timer++;
	}

	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			int u = scan.nextInt() - 1;
			int v = scan.nextInt() - 1;
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		inTime = new int[n];
		outTime = new int[n];
		timer = 1;
		Arrays.fill(inTime, -1);
		Arrays.fill(outTime, -1);

		preprocess(0, adj);

		int no = scan.nextInt();
		while (no-- > 0) {
			int dir = scan.nextInt();
			int oli = scan.nextInt() - 1;
			int bob = scan.nextInt() - 1;

			if (dir == 0) {
				if (inTime[bob] > inTime[oli] && outTime[bob] < outTime[oli]) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			} else {
				if (inTime[bob] < inTime[oli] && outTime[bob] > outTime[oli]) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

}
