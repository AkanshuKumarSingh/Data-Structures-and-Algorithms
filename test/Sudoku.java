package test;

import java.util.*;

public class Sudoku {

	public static boolean isSafe(int row, int col, int no, char board[][]) {
		for (int c = 0; c < 9; c++) {
			if (board[row][c] == (char) (no + '0')) {
				return false;
			}
		}

		for (int r = 0; r < 9; r++) {
			if (board[r][col] == (char) (no + '0')) {
				return false;
			}
		}

		int rowNo = (row / 3) * 3;
		int colNo = (col / 3) * 3;
		for (int i = rowNo; i < rowNo + 3; i++) {
			for (int j = colNo; j < colNo + 3; j++) {
				if (board[i][j] == (char) (no + '0')) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean solve(char[][] board) {
		int i = 0, j = 0;
		outer: for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					break outer;
				}
			}
		}

		if (i == 9 && j == 9) {
			return true;
		}
		for(int n = 1; n <= 9; n++) {
			if(isSafe(i,j,n,board)) {
				board[i][j] = (char)(n + '0');
				if(solve(board)) {
					return true;
				}
				board[i][j] = '.';
			}
		}

		return false;
	}

	public static void solveSudoku(char[][] board) {
		solve(board);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = 9;
		char[][] arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = scn.nextLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		solveSudoku(arr);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}