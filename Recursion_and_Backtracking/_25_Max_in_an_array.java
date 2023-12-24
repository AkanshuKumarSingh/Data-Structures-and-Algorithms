package Recursion_and_Backtracking;

import java.util.Scanner;

public class _25_Max_in_an_array {
//	1. You are given a number n, representing the count of elements.
//	2. You are given n numbers.
//	3. You are required to find the maximum of input. 
//	4. For the purpose complete the body of maxOfArray function. Don't change the signature.

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println(maxOfArray(arr,0));
	}

    public static int maxOfArray(int[] arr, int idx){
        if(idx == arr.length) {
        	return Integer.MIN_VALUE;
        }
        int maxFromidxPlus1 = maxOfArray(arr,idx+1);
    	return Math.max(arr[idx],maxFromidxPlus1);
    }

}
