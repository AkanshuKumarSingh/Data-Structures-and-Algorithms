package Array;

import java.util.Scanner;

public class _7_Difference_of_2_arrays {
//	1. You are given a number n1, representing the size of array a1.
//	2. You are given n1 numbers, representing elements of array a1.
//	3. You are given a number n2, representing the size of array a2.
//	4. You are given n2 numbers, representing elements of array a2.
//	5. The two arrays represent digits of two numbers.
//	6. You are required to find the difference of two numbers represented by two arrays and print the arrays. a2 - a1

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n1 = scan.nextInt();
		int arr1[] = new int[n1];
		
		for(int i = 0 ; i < n1 ; i++) {
			arr1[i] = scan.nextInt();
		}
		
		int n2 = scan.nextInt();
		int arr2[] = new int[n2];
		
		for(int i = 0 ; i < n2 ; i++) {
			arr2[i] = scan.nextInt();
		}
		
		int max = n2;
		
		int res[] = new int[max];

		int i = n1-1, j = n2-1,k = max-1,carry = 0;
		
		while(j >= 0) {
			int subtract = arr2[j] + carry - (i > -1 ? arr1[i] : 0) ;
			if(subtract < 0) {
				subtract += 10;
				carry = -1;
			}else {
				carry = 0;
			}
			res[k] = subtract%10; // res[k] = subtract is also fine
			k--;
			i--;
			j--;
		}
		
		for(i = 0 ; i < max; i++) {
			if(res[i] != 0)
				break;
		}
		
		for(;i < max; i++) {
			System.out.println(res[i]);
		}
	}

	
}
