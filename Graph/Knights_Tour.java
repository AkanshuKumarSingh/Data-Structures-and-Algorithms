package Graph;

import java.util.Scanner;

public class Knights_Tour {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int r = scan.nextInt();
		int c = scan.nextInt();

		int board[][] = new int[n][n];
		printKnightsTour(board, r, c, 1);
	}

	public static int rdir[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	public static int cdir[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
		if (upcomingMove == chess.length * chess.length) {
			chess[r][c] = upcomingMove;
			displayBoard(chess);
			chess[r][c] = 0;
			return;
		}
		chess[r][c] = upcomingMove;
		for (int i = 0; i < rdir.length; i++) {
			int rr = r + rdir[i];
			int cc = c + cdir[i];
			if (rr >= 0 && rr < chess.length && cc >= 0 && cc < chess[0].length && chess[rr][cc] == 0) {
				printKnightsTour(chess, rr, cc, upcomingMove + 1);
			}
		}
		chess[r][c] = 0;
	}

	public static void displayBoard(int[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
	}
}
