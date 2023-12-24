package Recursion_and_Backtracking;

import java.util.Scanner;

public class _17_Print_Stairs_Path {
//	1. You are given a number n representing number of stairs in a staircase.
//	2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
//	3. Complete the body of printStairPaths function - without changing signature - to print the list of all paths that can be used to climb the staircase up.
//	Use sample input and output to take idea about output.

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
//		printStairPaths(n,"");
//		int[] jumps = { 4, 2, 3, 0, 2, 4, 3 };
		int[] jumps = { 3, 3, 3, 3, 3, 3, 3 };
		printStairPaths(n, "", jumps);
	}

	public static void printStairPaths(int n, String ans, int[] jumps) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}

		for (int steps = 1; steps <= jumps[n-1]; steps++) {
			if (n - steps >= 0) {
				printStairPaths(n - steps, ans + steps, jumps);
			}
		}
	}

	public static void printStairPaths(int n, String path) {
		if (n == 0) {
			System.out.println(path);
			return;
		}

		for (int steps = 1; steps <= 3; steps++) {
			if (n - steps >= 0) {
				printStairPaths(n - steps, path + steps);
			}
		}

	}

}
