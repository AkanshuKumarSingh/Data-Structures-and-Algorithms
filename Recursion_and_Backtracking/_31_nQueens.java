package Recursion_and_Backtracking;

import java.util.Scanner;

public class _31_nQueens {

	public static boolean isSafePlaceNaive(boolean board[][], int r, int c) {
		// North
		for (int i = 0; i < r; i++) {
			if (board[i][c] == true)
				return false;
		}

		// South
		for (int i = r + 1; i < board.length; i++) {
			if (board[i][c] == true)
				return false;
		}

		// east
		for (int i = 0; i < c; i++) {
			if (board[r][i] == true)
				return false;
		}

		// west
		for (int i = c + 1; i < board[0].length; i++) {
			if (board[r][i] == true)
				return false;
		}

		// North east
		int i = r, j = c;
		while (i >= 0 && j >= 0) {
			if (board[i][j] == true)
				return false;
			i--;
			j--;
		}

		// North west
		i = r;
		j = c;
		while (i >= 0 && j < board[0].length) {
			if (board[i][j] == true)
				return false;
			i--;
			j++;
		}

		// South east
		i = r;
		j = c;
		while (i < board.length && j >= 0) {
			if (board[i][j] == true)
				return false;
			i++;
			j--;
		}

		// South west
		i = r;
		j = c;
		while (i < board.length && j < board[0].length) {
			if (board[i][j] == true)
				return false;
			i++;
			j++;
		}

		return true;
		
	}

	public static boolean isSafePlace(boolean board[][], int r, int c) {

		// North
		for(int i = r; i >= 0; i--) {
			if(board[i][c] == true) {
				return false;
			}
		}
		
		//north east
		for(int i = r,j = c; i >= 0 && j >= 0; i--,j--) {
			if(board[i][j] == true)
				return false;
		}
		
		//north west
		for(int i = r,j = c; i >= 0 && j < board[0].length; i--,j++) {
			if(board[i][j] == true)
				return false;
		}
		
		// only these 3 are sufficient
		
		return true;
		
	}
	
//	4
//	0-1, 1-3, 2-0, 3-2, 
//	0-2, 1-0, 2-3, 3-1, 
	public static void nqueen(boolean board[][], int r, String asf) {
		if (r == board.length) {
			System.out.println(asf + ".4");
			return;
		}

		for (int c = 0; c < board[0].length; c++) {
			if (isSafePlaceNaive(board, r, c)) {
				board[r][c] = true;
				nqueen(board, r + 1, asf + r + "-" + c + ", ");
				board[r][c] = false;
			}
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		boolean board[][] = new boolean[n][n];
		nqueen(board, 0, "");

	}

}
