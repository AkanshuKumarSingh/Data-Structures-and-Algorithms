package Array;

import java.util.Scanner;

public class _1_Span_of_array {

//	1. You are given a number n, representing the count of elements.
//	2. You are given n numbers.
//	3. You are required to find the span of input. Span is defined as difference of maximum value and minimum value.
//	Input Format
//	A number n
//	n1
//	n2
//	.. n number of elements
//	Output Format
//	A number representing max - min
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i = 0 ; i < n ; i++) {
			arr[i] = scan.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < n ; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}
		System.out.println(max-min);

	}

}
