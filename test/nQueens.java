package test;

import java.util.*;

public class nQueens {
	
	static List<List<String>> ans = new ArrayList<>();

	public static boolean isSafe1(int row, int col, int mat[][]) {
		for(int i = 0; i < row; i++) {
			if(mat[i][col] == 1)
				return false;
		}
		
		for(int i = row,j = col; i >= 0 && j >= 0; i--,j--) {
			if(mat[i][j] == 1) {
				return false;
			}
		}
		
		for(int i = row,j = col; i >= 0 && j < mat.length; i--,j++) {
			if(mat[i][j] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isSafe(int r, int c, int board[][]) {
		// North
		for(int i = r; i >= 0; i--) {
			if(board[i][c] == 1) {
				return false;
			}
		}
		
		//north east
		for(int i = r,j = c; i >= 0 && j >= 0; i--,j--) {
			if(board[i][j] == 1)
				return false;
		}
		
		//north west
		for(int i = r,j = c; i >= 0 && j < board[0].length; i--,j++) {
			if(board[i][j] == 1)
				return false;
		}
		
		return true;
	}
	
	public static void queen(int mat[][], int r){
		if(r == mat.length) {
			List<String> temp = new ArrayList<>();
			for(int i = 0; i < mat.length; i++) {
				String t = "";
				for(int j = 0; j < mat[0].length; j++) {
					if(mat[i][j] == 1) {
						t += "Q";
					}else {
						t += ".";
					}
				}
				temp.add(t);
			}
			ans.add(temp);
			return;
		}
		
		for (int c = 0; c < mat[0].length; c++) {
			if (isSafe1(r, c,mat)) {
				mat[r][c] = 1;
				queen(mat, r + 1);
				mat[r][c] = 0;
			}
		}
		
	}
	
//	public static List<List<String>> queen(int mat[][], int row){
//		if(row == mat.length) {
//			List<List<String>> ans = new ArrayList<>();
//			List<String> t = new ArrayList<>();
//			ans.add(t);
//			return ans;
//		}
//		
//		List<List<String>> cres = new ArrayList<>();
//		for(int c = 0; c < mat.length; c++) {
//			if(isSafe(row,c,mat)) {
//				mat[row][c] = 1;
//				List<List<String>> rres = queen(mat,row+1);
//				if(!rres.isEmpty()) {
//					String ans = "";
//					for(int i = 0; i < mat.length; i++) {
//						if(i == c)
//							ans += "Q";
//						else
//							ans += ".";
//					}
//					for(List<String> e : rres) {
//						List<String> t = new ArrayList<>();
//						t.add(ans);
//						t.addAll(e);
//						cres.add(t);
//					}
//				}
//				mat[row][c] = 0;
//			}
//		}
//		return cres;
//	}
	
	public static List<List<String>> solveNQueens(int n) {
		int mat[][] = new int[n][n];
		queen(mat,0);
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		List<List<String>> res = solveNQueens(n);
		System.out.println(res);
	}

}
