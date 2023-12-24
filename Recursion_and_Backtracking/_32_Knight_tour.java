package Recursion_and_Backtracking;

import java.util.Scanner;

public class _32_Knight_tour {

	public static int rdir[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	public static int cdir[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void displayBoard(int[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void knightTour(int board[][], int r, int c, int step) {

		if (step == board.length * board.length) {
			board[r][c] = step;
			displayBoard(board);
			board[r][c] = 0;
			return;
		}

		board[r][c] = step;
		for (int i = 0; i < rdir.length; i++) {
			int rr = r + rdir[i];
			int cc = c + cdir[i];
			if (rr >= 0 && rr < board.length && cc >= 0 && cc < board[0].length && board[rr][cc] == 0) {
				knightTour(board, rr, cc, step + 1);
			}
		}
		board[r][c] = 0;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int r = scan.nextInt();
		int c = scan.nextInt();

		int board[][] = new int[n][n];
		knightTour(board, r, c, 1);
	}

}
