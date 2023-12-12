package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class _20_Rat_in_a_Maze_Problem_1 {
	
    static int row[] = {-1, 1, 0, 0};
    static int col[] = {0, 0, -1, 1};
    static String dir[] = {"U", "D", "L", "R"};
    
    public static ArrayList<String> path(int m[][], int r, int c){
        System.out.println(r + ", " + c);
        if(r == m.length-1 && c == m[0].length-1){
            ArrayList<String> currAns = new ArrayList<>();
            currAns.add("");
            return currAns;
        }
        m[r][c] = 0;        
        ArrayList<String> currAns = new ArrayList<>();
        for(int i = 0; i < row.length; i++){
            int nr = r + row[i];
            int nc = c + col[i];
            if(nr >= 0 && nr < m.length && nc >= 0 && nc < m[0].length && m[nr][nc] == 1){
            	ArrayList<String> ans = path(m, nr, nc);
                for(String str: ans){
                    currAns.add(dir[i] + str);
                }
            }
        }
        m[r][c] = 1;
        return currAns;
    }
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        return path(m, 0, 0);
        
        
    }


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = 4;
		int m[][] = {{1,1}, {1,1}};
		ArrayList<String> paths = findPath(m, n);
		System.out.println(paths);
	}

}
