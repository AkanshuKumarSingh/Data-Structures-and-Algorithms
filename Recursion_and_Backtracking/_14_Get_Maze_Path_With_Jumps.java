package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class _14_Get_Maze_Path_With_Jumps {
//	1. You are given a number n and a number m representing number of rows and columns in a maze.
//	2. You are standing in the top-left corner and have to reach the bottom-right corner. 
//	3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
//	4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
//	Use sample input and output to take idea about output.

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		System.out.println(getMazePaths(1, 1, n, m));
	}

	public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
		if(sr == dr && sc == dc) {
			ArrayList<String> ans = new ArrayList<>();
			ans.add("");
			return ans;
		}
		
		ArrayList<String> rres = new ArrayList<>();
		
		for(int steps = 1; steps+sc <= dc; steps++) {
			ArrayList<String> cres = getMazePaths(sr,sc+steps,dr,dc);
			for(String t : cres) {
				rres.add("h"+steps+t);
			}
		}
		
		for(int steps = 1; steps+sr <= dr; steps++) {
			ArrayList<String> cres = getMazePaths(sr+steps,sc,dr,dc);
			for(String t : cres) {
				rres.add("v"+steps+t);
			}
		}
		
		int i = 1,j = 1;
		while(i+sr <= dr && j+sc <= dc) {
			ArrayList<String> dres = getMazePaths(sr+i,sc+j,dr,dc);
			for(String t : dres) {
				rres.add("d"+i+t);
			}
			i++;
			j++;
		}
		
		return rres;
	}

//	def get_maze_paths(sr, sc, dr, dc):
//	    if sr == dr and sc == dc:
//	        return [""]
//
//	    rres = []
//
//	    # Horizontal moves
//	    for steps in range(1, dc - sc + 1):
//	        cres = get_maze_paths(sr, sc + steps, dr, dc)
//	        for t in cres:
//	            rres.append(f"h{steps}{t}")
//
//	    # Vertical moves
//	    for steps in range(1, dr - sr + 1):
//	        cres = get_maze_paths(sr + steps, sc, dr, dc)
//	        for t in cres:
//	            rres.append(f"v{steps}{t}")
//
//	    # Diagonal moves
//	    i, j = 1, 1
//	    while sr + i <= dr and sc + j <= dc:
//	        dres = get_maze_paths(sr + i, sc + j, dr, dc)
//	        for t in dres:
//	            rres.append(f"d{i}{t}")
//	        i += 1
//	        j += 1
//
//	    return rres
//
//	# Example usage
//	paths = get_maze_paths(0, 0, 2, 2)
//	print(paths)
	
}
