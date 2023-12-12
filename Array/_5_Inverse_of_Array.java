package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _5_Inverse_of_Array {
	
//	1. You are given a number n, representing the size of array a.
//	2. You are given n numbers, representing elements of array a.
//	3. You are required to calculate the inverse of array a.
//
//	The only difference is the range of values is from 0 to n - 1, instead of 1 to n.
//	Sample Input
//	5
//	4
//	0
//	2
//	3
//	1
//	Sample Output
//	1
//	4
//	2
//	3
//	0
	 public static void display(int[] a){
		    StringBuilder sb = new StringBuilder();

		    for(int val: a){
		      sb.append(val + "\n");
		    }
		    System.out.println(sb);
		  }

		  public static int[] inverse(int[] a){
		    int res[] = new int[a.length];
		    
		    for(int i = 0 ; i < a.length; i++) {
		    	res[a[i]] = i;
		    }
		    return res;
		  }

		public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		    int n = Integer.parseInt(br.readLine());
		    int[] a = new int[n];
		    for(int i = 0; i < n; i++){
		       a[i] = Integer.parseInt(br.readLine());
		    }

		    int[] inv = inverse(a);
		    display(inv);
		 }

}
