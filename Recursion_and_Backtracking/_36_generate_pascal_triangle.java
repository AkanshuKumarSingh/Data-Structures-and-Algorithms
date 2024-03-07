package Recursion_and_Backtracking;

import java.util.ArrayList;

public class _36_generate_pascal_triangle {

	public static int[][] generate(int n) {
		int arr[][] = new int[n][];
		for (int i = 0; i < n; i++) {
			int colLen = i + 1;
			arr[i] = new int[colLen];
			arr[i][0] = arr[i][colLen - 1] = 1;
			for (int j = 1; j < colLen - 1; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
			}
		}
		return arr;
	}

	static void printPascal(int arr[][], int n) {

		for (int i = 0; i < n; i++) {
			int colLen = arr[i].length;
			for (int j = 0; j < colLen; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	ArrayList<Long> nthRowOfPascalTriangle1(int n) {
		ArrayList<Long> ans = new ArrayList<>();
		long C = 1;
		for (int j = 1; j <= n; j++) {
			ans.add(C);
			C = (((C * (n - j)) % 1000000007) / j);
		}
		return ans;
	}

	ArrayList<Long> nthRowOfPascalTriangle(int n) {
		ArrayList<ArrayList<Long>> arr = new ArrayList<>();
		ArrayList<Long> carr = new ArrayList<>();
		if (n == 1) {
			carr.add((long) 1);
			return carr;
		}

		for (int i = 0; i < n; i++) {
			int colLen = i + 1;
			carr = new ArrayList<>();
			carr.add(0, (long) 1);
			for (int j = 1; j < colLen - 1; j++) {
				carr.add((arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j)) % 1000000007);
			}
			carr.add((long) 1);
			arr.add(carr);
		}
		return carr;

//		O(n) not working
//        n--;
//        ArrayList<Long> ans = new ArrayList<>();
//        ans.add((long)1);
//        long prevNo = 1, num = n, den = 1, mod = 1000000007;
//        for(int j = 1; j < n; j++){
//            long currNo = (((prevNo*num))/den)%mod;
//            num--;
//            den++;
//            ans.add(currNo);
//            prevNo = currNo;
//        }
//        if(n != 0)
//            ans.add((long)1);
//        return ans;
	}

	public static void main(String args[]) {
		printPascal(generate(5), 5);
	}

}
