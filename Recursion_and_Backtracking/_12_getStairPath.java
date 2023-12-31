package Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class _12_getStairPath {
//	1. You are given a number n representing number of stairs in a staircase.
//	2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
//	3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
//	Use sample input and output to take idea about output.
//  3 -> [111, 12, 21, 3]

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(getStairPaths(n));
	}

	public static ArrayList<String> getStairPaths(int n) {
		if (n == 0) {
			ArrayList<String> ans = new ArrayList<>();
			ans.add("");
			return ans;
		}

		ArrayList<String> cres = new ArrayList<>();
		for (int steps = 1; steps <= 3; steps++) {
			if (n - steps >= 0) {
				ArrayList<String> rres = getStairPaths(n - steps);
				for (String t : rres) {
					cres.add("" + steps + t);
				}
			}
		}
		return cres;
	}

}
