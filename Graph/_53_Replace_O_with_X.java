package Graph;

public class _53_Replace_O_with_X {

	static int xDir[] = { -1, 0, 1, 0 };
	static int yDir[] = { 0, 1, 0, -1 };

	static void dfs(int st, int end, int n, int m, boolean vis[][], char matrix[][]) {
		vis[st][end] = true;

		for (int i = 0; i < 4; i++) {
			int nx = st + xDir[i];
			int ny = end + yDir[i];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix[nx][ny] == 'O' && !vis[nx][ny]) {
				dfs(nx, ny, n, m, vis, matrix);
			}
		}

	}

	static char[][] fill(int n, int m, char a[][]) {
		boolean vis[][] = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 'O' && (i == 0 || i == n - 1 || j == 0 || j == m - 1) && !vis[i][j]) {
					dfs(i, j, n, m, vis, a);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 'O' && !vis[i][j]) {
					a[i][j] = 'X';
				}
			}
		}

		return a;
	}

}
