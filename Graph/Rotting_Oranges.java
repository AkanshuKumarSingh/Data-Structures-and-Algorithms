package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {

	static class OPair {
		int x;
		int y;
		int t;

		OPair(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	public int orangesRotting(int[][] grid) {
		Queue<OPair> q = new LinkedList<>();
		int freshOranges = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					freshOranges++;
				} else if (grid[i][j] == 2) {
					q.add(new OPair(i, j, 0));
				}
			}
		}

		freshOranges += q.size();
		int time = 0;
		int xdir[] = { -1, 0, 1, 0 };
		int ydir[] = { 0, -1, 0, 1 };

		while (!q.isEmpty()) {
			OPair rem = q.poll();
			int x = rem.x;
			int y = rem.y;
			int t = rem.t;

			if (grid[x][y] == -1) {
				continue;
			}
			grid[x][y] = -1;
			freshOranges--;
			time = t;

			for (int d = 0; d < 4; d++) {
				int r = x + xdir[d];
				int c = y + ydir[d];
				if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
					q.offer(new OPair(r,c,t+1));
				}
			}

		}
		
		if(freshOranges == 0) return time;
		return -1;

	}

	public static void main(String args[]) {
		Rotting_Oranges r = new Rotting_Oranges();
		int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(r.orangesRotting(grid));
	}

}
