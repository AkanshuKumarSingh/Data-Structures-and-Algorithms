package DP;

import java.util.Scanner;

public class Paint_Houses {

//	public static int phRecursive(int idx, int mat[][],int p) {
//		if(idx == mat.length) {
//			return 0;
//		}
//		
//		int min = Integer.MAX_VALUE;
//		for(int i = 0; i < 3; i++) {
//			if(i != p)
//				min = Math.min(min, mat[idx][i]+phRecursive(idx+1,mat,));
//		}
//		return min;
//	}
	
	public static int phTabulationSir(int arr[][]) {
		int red = arr[0][0];
		int green = arr[0][1];
		int blue = arr[0][2];
		
		for(int i = 1; i < arr.length; i++) {
			int n_red = Math.min(green,blue) + arr[i][0];
			int n_green = Math.min(red,blue) + arr[i][1];
			int n_blue = Math.min(red, green) + arr[i][2];
			
			red = n_red;
			green = n_green;
			blue = n_blue;
		}
		
		if(red > green && blue > green) {
			return green;
		}else if(blue > red) {
			return red;
		}else {
			return blue;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int mat[][] = new int[n][3];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0; j < 3; j++) {
				mat[i][j] = scan.nextInt();
			}
		}
//		System.out.println(phRecursive(0,mat,-1));
		System.out.println(phTabulationSir(mat));
	}

}
