package Recursion_and_Backtracking;

import java.util.Scanner;

public class _23_Display_Array {
//	1. You are given a number n, representing the size of array a.
//	2. You are given n numbers, representing elements of array a.
//	3. You are required to print the elements of array from beginning to end each in a separate line.
//	4. For the above purpose complete the body of displayArr function. Don't change the signature.

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i = 0 ; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		displayArr(arr,0);
		System.out.println("Welcome");
	}

    public static void displayArr(int[] arr, int idx){
        if(idx == arr.length) {
        	System.out.println();
        	return;
        }
    	
    	System.out.print(arr[idx] + " ");
    	displayArr(arr,idx+1);
    }

}
