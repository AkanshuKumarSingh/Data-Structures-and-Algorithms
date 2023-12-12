package Graph;

public class _26_Find_the_number_of_islands {
	
    static int moveX[] = {1,  1,  0, -1, -1, -1, 0, 1};
    static int moveY[] = {0, -1, -1, -1,  0,  1, 1, 1};
    
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public void dfs(int x, int y, char grid[][]){
        grid[x][y] = '0';
        for(int i = 0 ; i < moveX.length; i++){
            int nx = x + moveX[i];
            int ny = y + moveY[i];
            if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == '1'){
                dfs(nx, ny, grid);
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        
        int comps = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    comps++;
                }
            }
        }
        return comps;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
