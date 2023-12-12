package Recursion_in_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePath {
//	1. You are given a number n and a number m representing number of rows and columns in a maze.
//	2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
//	3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
//	Use sample input and output to take idea about output.
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		System.out.println(getMazePaths(1, 1, n, m));
	}

// sr - source row
// sc - source column
// dr - destination row
// dc - destination column
	public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

		if (sr == dr && sc == dc) {
			ArrayList<String> ans = new ArrayList<>();
			ans.add("");
			return ans;
		}

		ArrayList<String> cres = new ArrayList<>();

		if (sc + 1 <= dc) {
			ArrayList<String> rres = getMazePaths(sr, sc + 1, dr, dc);
			for (String t : rres) {
				cres.add("h" + t);
			}
		}

		if (sr + 1 <= dr) {
			ArrayList<String> rres = getMazePaths(sr + 1, sc, dr, dc);
			for (String t : rres) {
				cres.add("v" + t);
			}
		}
		return cres;
	}
	
}
