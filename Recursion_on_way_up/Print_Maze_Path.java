package Recursion_on_way_up;

import java.util.Scanner;

public class Print_Maze_Path {
//	1. You are given a number n and a number m representing number of rows and columns in a maze.
//	2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
//	3. Complete the body of pri tMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
//	Use sample input and output to take idea about output.

	
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc) {
        	System.out.println(psf);
        	return;
        }
        
        if(sc + 1 <= dc) {
        	printMazePaths(sr,sc+1,dr,dc,psf+"h");
        }
        
        if(sr + 1 <= dr) {
        	printMazePaths(sr+1,sc,dr,dc,psf+"v");
        }
        
    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		printMazePaths(1,1,n,m,"");
	}

}
