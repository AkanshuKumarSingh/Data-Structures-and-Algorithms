package Array;

import java.util.Scanner;

public class _6_Sum_of_2_arrays {
//	1. You are given a number n1, representing the size of array a1.
//	2. You are given n1 numbers, representing elements of array a1.
//	3. You are given a number n2, representing the size of array a2.
//	4. You are given n2 numbers, representing elements of array a2.
//	5. The two arrays represent digits of two numbers.
//	6. You are required to add the numbers represented by two arrays and print the
//	arrays.

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
		
		int max = Math.max(n1, n2) + 1;
		
		int res[] = new int[max];

		int i = n1-1, j = n2-1,k = max-1,carry = 0;
		
		while(i >= 0 || j >= 0 || carry == 1) { // while k >= 0 -- best
			int sum = (i >= 0 ? arr1[i] : 0) + (j >= 0 ? arr2[j] : 0) + (carry);
			res[k] = sum%10;
			carry = sum/10;
			k--;
			i--;
			j--;
		}
		
		for(i = 0 ; i < max; i++) {
			if(i == 0 && res[i] == 0) {
				continue;
			}
			System.out.println(res[i]);
		}
		
		
//		python code
//		n1 = int(input())
//		arr1 = [int(input()) for _ in range(n1)]
//		n2 = int(input())
//		arr2 = [int(input()) for _ in range(n2)]
//		curr_max = max(n1, n2) + 1
//		res = [0] * curr_max
//		i = n1-1
//		j = n2-1
//		k = curr_max-1
//		carry = 0
//		while i >= 0 or j >= 0 or carry == 1:
//		    sum = (arr1[i] if i >= 0 else 0) + (arr2[j] if j >= 0 else 0) + carry
//		    res[k] = sum % 10
//		    carry = sum // 10
//		    k -= 1
//		    i -= 1
//		    j -= 1
//		for i in range(curr_max):
//		    if i == 0 and res[i] == 0:
//		        continue
//		    print(res[i])
		
	}

}
