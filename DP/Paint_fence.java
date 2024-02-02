package DP;

import java.util.Scanner;

public class Paint_fence {

	public static int pfRecursive(int n, int k) {
		if(n == 0) {
			return 1;
		}
		int cnt = 0;
		for(int i = 1; i <= k; i++) {
			cnt += pfRecursive(n-1,k);
			if(n-2 >= 0) {
				cnt += pfRecursive(n-2,k);	
			}
		}
		return cnt;
	}
	
	public static long pfTabulation(int n, int k) {
		// Sir
		if(n == 1) return k;
		long same = k;
		long diff = k*(k-1);
		
		for(int i = 3; i <= n; i++) {
			long nsame = diff;
			long ndiff = (same+diff)*(k-1);
			
			same = nsame;
			diff = ndiff;
		}
		
		return same+diff;
	}
	
	public static void main(String[] args) {
		System.out.println("HHM");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		System.out.println(k*(pfRecursive(n-1,k-1) + pfRecursive(n-2,k-1)));
		System.out.println(pfTabulation(n,k));
	}

}
