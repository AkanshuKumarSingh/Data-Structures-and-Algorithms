package Graph;

public class _51_Number_of_Triangles {

	public static int numberOfTriangles(int n, int[][] g) {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (i != k && i != j && j != k && g[i][j] == 1 && g[j][k] == 1 && g[k][i] == 1)
						ans++;

				}
			}
		}
		return ans / 3;
	}

}
