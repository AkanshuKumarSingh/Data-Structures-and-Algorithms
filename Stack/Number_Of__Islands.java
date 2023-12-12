package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Number_Of__Islands {

	public static int xdir[] = { -1, 0, 1, 0 };
	public static int ydir[] = { 0, -1, 0, 1 };

	public static void numberOfIslandsComp(int graph[][], int x, int y) {
		graph[x][y] = 1;
		for (int dir = 0; dir < 4; dir++) {
			int r = x + xdir[dir];
			int c = y + ydir[dir];
			if(r >= 0 && r < graph.length && c >= 0 && c < graph[0].length && graph[r][c] == 0) {
				numberOfIslandsComp(graph,r,c);
			}
		}
	}

	public static int numberOfIslands(int graph[][]) {
		int cnt = 0;

		int n = graph.length;
		int m = graph[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 0) {
					numberOfIslandsComp(graph, i, j);
					cnt++;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[m][n];

		for (int i = 0; i < arr.length; i++) {
			String parts = br.readLine();
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
			}
		}

		int res = numberOfIslands(arr);
		System.out.println(res);
		// write your code here
	}

}
