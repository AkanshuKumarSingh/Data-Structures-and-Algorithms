package Graph;

import java.util.Arrays;

public class _35_M_Coloring_Problem {

    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour
    static int color[];
    
	public static boolean isSafe(boolean graph[][], int node, int c) {
		for(int i = 0; i < graph[node].length; i++){
		    if(graph[node][i] && color[i] == c){
		        return false;
		    }
		}
		return true;
	}
    
    public static boolean colorIt(boolean graph[][], int node, int m, int n){
        if(node == n){
            return true;
        }
        
        for(int c = 0; c < m; c++){
            if(isSafe(graph, node, c)){
                color[node] = c;
                if(colorIt(graph, node+1, m, n)) return true;
                color[node] = -1;
            }
        }
        
        return false;
    }
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        color = new int[n];
        for(int i = 0; i < n; i++){
            color[i] = -1;
        }
        Arrays.fill(color,-1);
        return colorIt(graph, 0, m, n);
    }

	
}
