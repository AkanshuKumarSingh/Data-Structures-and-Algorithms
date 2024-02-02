package DP;

import java.util.Scanner;

public class Tiling_With_M_1_Tiles {

	public static int tilesRecursion(int n, int m) {
		 if(n < m){
             return 1;
         }else if(n == m){
             return 2;
         }else{
             return tilesRecursion(n-1, m) + tilesRecursion(n-m, m);
         }
	}
	
	public static int tilesTabulation(int n, int m) {
		int dp[] = new int[n+1];
		
		for(int i = 1 ; i <= n; i++) {
			if(i < m) {
				dp[i]  = 1;
			}else if(i == m) {
				dp[i] = 2;
			}else {
				dp[i] = dp[i-1] + dp[i-m];
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		System.out.println("JSR");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		System.out.println(tilesTabulation(n,m));
		
	}

}
