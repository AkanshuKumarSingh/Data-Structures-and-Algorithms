package Array;

import java.util.Scanner;

public class arrayDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println(-7%6);
		
		int arr[] = new int[5];
		for(int i = 0 ; i < 5 ; i++) {
			arr[i] = scan.nextInt();
		}
		
		int min = arr[0];
		int max = arr[0];
		
		for(int i = 0 ; i < 5 ; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		
		System.out.println("min : " + min + ", max : " + max);
		
		for(int i = 0 ; i < 5 ; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}

}
