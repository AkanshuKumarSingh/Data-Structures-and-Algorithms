package Array;

import java.util.Scanner;

public class Subsets_of_array {
//	1. You are given a number n, representing the count of elements.
//	2. You are given n numbers.
//	3. You are required to print all subsets of arr. Each subset should be
//	on separate line. For more clarity check out sample input and output.

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		int no = (int)Math.pow(2, n)-1;
		
		for(int i = 0 ; i <= no; i++) {
			String ans = "";
			int t = i;
			int j = n;
			while(j-- > 0) {
				if(t%2 == 1) {
					ans = arr[j] + "\t" + ans;
				}else {
					ans = "-\t" + ans;
				}
				t = t/2;
			}
			System.out.println(ans);
		}
		
	}

}
