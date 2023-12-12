package DynamicProgramming;

import java.util.Scanner;

public class Count_Binary_String {

	public static int CBSRecursive(int n, boolean waslastZero) {
		if(n == 0) {
			return 1;
		}
		int ans = 0;
		if(!waslastZero) {
			ans = CBSRecursive(n-1,true);
		}
		ans += CBSRecursive(n-1,false);
		return ans;
	}
	
	public static int CBSRecursiveSir(int clen,int n, int le,String ans) {
		if(clen == n) {
			return 1;
		}
		
		int cnt = 0;
		if(le == 0) {
			cnt = CBSRecursiveSir(clen+1,n,1,ans + "1");
		}else {
			cnt = CBSRecursiveSir(clen+1,n,0,ans + "0");
			cnt += CBSRecursiveSir(clen+1,n,1,ans + "1");
		}
		return cnt;
	}
	
	public static int CBSMemoization(int clen,int n, int le,String ans,int dp[][]) {
		if(clen == n) {
			return dp[le][clen] = 1;
		}
		
		if(dp[le][clen] != 0) return dp[le][clen];
		
		int cnt = 0;
		if(le == 0) {
			cnt = CBSMemoization(clen+1,n,1,ans + "1",dp);
		}else {
			cnt = CBSMemoization(clen+1,n,0,ans + "0",dp);
			cnt += CBSMemoization(clen+1,n,1,ans + "1",dp);
		}
		return dp[le][clen] = cnt;
	}
	
	public static int CBSTabulation(int n) {
		
		int oldZero = 1;
		int oldOne = 1;
		
		for(int i = 2; i <= n; i++) {
			int newZero = oldOne;
			int newOne = oldZero + oldOne;
			
			oldZero = newZero;
			oldOne = newOne;
		}
		
		return oldOne+oldZero;	
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(CBSRecursive(n,false));
		
		int cnt = CBSRecursiveSir(1,n,0,"0");
		cnt += CBSRecursiveSir(1,n,1,"1");
		System.out.println(cnt);
		
		int dp[][] = new int[2][n+1];
		cnt = CBSMemoization(1,n,0,"0",dp);
		cnt += CBSMemoization(1,n,1,"1",dp);
		System.out.println(cnt);
		
		System.out.println((CBSTabulation(n)));
		
	}

}
