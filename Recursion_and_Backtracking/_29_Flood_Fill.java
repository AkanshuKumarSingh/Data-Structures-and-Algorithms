package Recursion_and_Backtracking;

import java.util.Scanner;

public class _29_Flood_Fill {

	// Backtracking is way to solve problem using recursive approach . it  find all possible combination
	// and in them backtrack which are not suitable;
	
	static boolean visited[][];
	static int rdir[] = { -1, 0, 1, 0 };
	static int cdir[] = { 0, -1, 0, 1 };
	static char chars[] = {'t','l','d','r'};
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		visited = new boolean[n][m];
		floodfillSmartCall(arr, 0, 0, "");
	}

	public static void floodfill(int[][] maze, int sr, int sc, String asf) {
		if (sr == maze.length - 1 && sc == maze[0].length - 1 && maze[sr][sc] != 1) {
			System.out.println(asf);
			return;
		}
		
		if(sr < 0 || sr >= maze.length || sc < 0 || sc >= maze[0].length || maze[sr][sc] == 1) {
			return;
		}
		
		maze[sr][sc] = 1;
		
		floodfill(maze,sr-1,sc,asf+"t");
		floodfill(maze,sr,sc-1,asf+"l");
		floodfill(maze,sr+1,sc,asf+"d");
		floodfill(maze,sr,sc+1,asf+"r");
		
		maze[sr][sc] = 0;
	}

	public static void floodfillSmartCall(int[][] maze, int sr, int sc, String asf) {
		if (sr == maze.length - 1 && sc == maze[0].length - 1 && maze[sr][sc] != 1) {
			System.out.println(asf);
			return;
		}

		if(sr < 0 || sr >= maze.length || sc < 0 || sc >= maze[0].length || maze[sr][sc] == 1) {
			return;
		}
		
		maze[sr][sc] = 1;
		
		for(int d = 0; d < 4; d++) {
			int r = sr + rdir[d];
			int c = sc + cdir[d];
			floodfillSmartCall(maze,r,c,asf+chars[d]);
		}
		
		maze[sr][sc] = 0;
	}

    static int rows[] = {-1, 0, 1, 0};
    static int cols[] = {0, 1, 0, -1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int currColor = image[sr][sc];
        image[sr][sc] = newColor;
        for(int i = 0 ; i < 4; i++){
            int nr = sr+rows[i];
            int nc = sc+cols[i];
            if(nr < image.length && nc < image[0].length && nr >= 0 && nc >= 0 && image[nr][nc] == currColor && image[nr][nc] != newColor){
                floodFill(image, nr, nc, newColor);
            }
        }
        return image;
    }
}
