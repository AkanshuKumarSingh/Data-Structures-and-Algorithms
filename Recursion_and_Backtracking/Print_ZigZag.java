package Recursion_and_Backtracking;

import java.util.Scanner;

public class Print_ZigZag {
//	1. Here are a few sets of inputs and outputs for your reference
//	Input1 -> 1
//	Output1 -> 1 1 1
//
//	Input2 -> 2
//	Output2 -> 2 1 1 1 2 1 1 1 2
//
//	Input2 -> 3
//	Output3 -> 3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3


	public static void pzz(int n) {
		if(n == 0) {
			return;
		}
		
		System.out.print(n + " ");
		pzz(n-1);
		System.out.print(n + " ");
		pzz(n-1);
		System.out.print(n + " ");
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		pzz(n);
	}

}
