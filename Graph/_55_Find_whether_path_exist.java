package Graph;

import java.util.*;

public class _55_Find_whether_path_exist {

	static int ROW = 0;
	static int COL = 0;

	static int rowNo[] = { -1, 0, 0, 1 };
	static int colNo[] = { 0, -1, 1, 0 };

	static class Point {
		int x;
		int y;
		int dis;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	};

	static boolean isValid(int row, int col) {
		return (row >= 0 && row < ROW && col >= 0 && col < COL);
	}

	static int BFS(int mat[][], Point src, Point dest) {
		if (mat[src.x][src.y] != 3 || mat[dest.x][dest.y] != 3) {
			return -1;
		}

		boolean visited[][] = new boolean[ROW][COL];

		visited[src.x][src.y] = true;

		Queue<Point> queue = new LinkedList<>();
		src.dis = 0;
		queue.add(src);

		while (!queue.isEmpty()) {
			Point pt = queue.remove();
			if (pt.x == dest.x && pt.y == dest.y)
				return pt.dis;
			for (int i = 0; i < 4; i++) {
				int row = pt.x + rowNo[i];
				int col = pt.y + colNo[i];

				if (isValid(row, col) && mat[row][col] == 3 && !visited[row][col]) {
					visited[row][col] = true;
					Point Adjcell = new Point(row, col);
					Adjcell.dis = pt.dis + 1;
					queue.add(Adjcell);
				}

			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println("HHM");

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();
		while (t-- > 0) {

			ROW = scn.nextInt();
			COL = ROW;

			int mat[][] = new int[ROW][COL];
			Point src = null;
			Point des = null;

			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					mat[i][j] = scn.nextInt();
					if (mat[i][j] == 1) {
						src = new Point(i, j);
						mat[i][j] = 3;

					}
					if (mat[i][j] == 2) {
						des = new Point(i, j);
						mat[i][j] = 3;
					}
				}
			}

			int dis = BFS(mat, src, des);
			if (dis == -1) {
				System.out.println(0);
			} else
				System.out.println(1);

		}
	}

}
