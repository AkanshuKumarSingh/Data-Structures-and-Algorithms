package Graph;

import java.util.PriorityQueue;

public class Minimum_Cost_Path {

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int distance;

		Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}

	static int ROW, COL;
	static boolean visited[][];
	static int xMoves[] = { 0, 0, -1, 1 };
	static int yMoves[] = { -1, 1, 0, 0 };

	public boolean isValid(int x, int y) {
		return (x >= 0 && x < ROW && y >= 0 && y < COL);
	}

	public int minimumCostPath(int[][] grid) {
		System.out.println("JSR");
		ROW = grid.length;
		COL = grid[0].length;
		visited = new boolean[ROW][COL];
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.offer(new Node(0, 0, grid[0][0]));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			if (x == ROW - 1 && y == COL - 1) {
				return node.distance;
			}
			for (int i = 0; i < xMoves.length; i++) {
				int x1 = x + xMoves[i];
				int y1 = y + yMoves[i];
				if (isValid(x1, y1) && !visited[x1][y1]) {
					visited[x1][y1] = true;
					q.offer(new Node(x1, y1, node.distance + grid[x1][y1]));
				}
			}
		}
		return -1;
	}

}
