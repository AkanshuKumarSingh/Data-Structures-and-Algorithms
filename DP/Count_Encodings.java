package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Count_Encodings {

	public static int CERecursive(String str) {
		if(str.length() == 0) {
			return 1;
		}
		
		if(str.charAt(0) == '0') return 0;
		
		int first_num = str.charAt(0) - '0';
		
		int cnt = CERecursive(str.substring(1));
		
		if(str.length() > 1) {
			int sec_num = str.charAt(1) - '0';
			int no = first_num*10 + sec_num;
			if(no <= 26) {
				cnt += CERecursive(str.substring(2));
			}
		}
		return cnt;
	}
	
	public static int CEMemoization(String str,int idx, int dp[]) {
		if(str.length() == idx) {
			return dp[idx] = 1;
		}
		
		if(str.charAt(idx) == '0') return dp[idx] = 0;
		
		if(dp[idx] != 0) return dp[idx];
		
		int first_num = str.charAt(idx) - '0';
		
		int cnt = CEMemoization(str,idx+1,dp);
		
		if(idx + 1 < str.length()) {
			int sec_num = str.charAt(idx+1) - '0';
			int no = first_num*10 + sec_num;
			if(no <= 26) {
				cnt += CEMemoization(str,idx+2,dp);
			}
		}
		return dp[idx] = cnt;
	}
	
	public static int CETabulation(String str) {
		int dp[] = new int[str.length()+1];
		for(int idx = dp.length-1; idx >= 0; idx--) {
			if(str.length() == idx) {
				dp[idx] = 1;
				continue;
			}
			
			if(str.charAt(idx) == '0') {
				dp[idx] = 0;
				continue;
			}
			
			int first_num = str.charAt(idx) - '0';
			
			int cnt = dp[idx+1];
			
			if(idx + 1 < str.length()) {
				int sec_num = str.charAt(idx+1) - '0';
				int no = first_num*10 + sec_num;
				if(no <= 26) {
					cnt += dp[idx+2];
				}
			}
			dp[idx] = cnt;
		}
		return dp[0];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine().trim();
		System.out.println(CERecursive(str));
		int[] dp = new int[str.length() + 1];
		System.out.println(CEMemoization(str,0,dp));
		System.out.println(Arrays.toString(dp));
		System.out.println(CETabulation(str));
	}

}
