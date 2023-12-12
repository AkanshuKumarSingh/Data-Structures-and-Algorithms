package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _21_Steps_by_Knight {
	
	// Can't use dfs in this case why? because if we use backtracking with marking even
	// then we get timeout and if we don't unmark to reduce time complexity then we 
	// can't get shortest path So we have to use BFS

    int rows[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
    int cols[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
    int dp[][];

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    

    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        boolean vis[][] = new boolean[N+1][N+1];
        int dis[][] = new int[N+1][N+1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(KnightPos[0], KnightPos[1]));

        
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr.x == TargetPos[0] && curr.y == TargetPos[1]){
                return dis[curr.x][curr.y];
            }
            if(vis[curr.x][curr.y]){
                continue;
            }
            
            vis[curr.x][curr.y] = true;
            for(int i = 0; i < rows.length; i++){
                int nx = curr.x + rows[i];
                int ny = curr.y + cols[i];
                if(nx > 0 && ny > 0 && nx <= N && ny <= N && !vis[nx][ny]){
                    dis[nx][ny] = dis[curr.x][curr.y] + 1;
                    q.add(new Node(nx, ny));
                }
            }
            
        }
        return -1;
    }
}
