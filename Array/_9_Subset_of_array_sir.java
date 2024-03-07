package Array;

import java.util.Scanner;

public class _9_Subset_of_array_sir {
//	1. You are given a number n, representing the count of elements.
//	2. You are given n numbers.
//	3. You are required to print all subsets of arr. Each subset should be
//	on separate line. For more clarity check out sample input and output.
//  Sample INPUT
//	3
//	10
//	20
//	30
//	Sample Output
//	-	-	-	
//	-	-	30	
//	-	20	-	
//	-	20	30	
//	10	-	-	
//	10	-	30	
//	10	20	-	
//	10	20	30	
//

	public static int getBinary(int n) {
		int pow = 1;
		int res = 0;
		
		while(n != 0) {
			int rem = n%2;
			n /= 2;
			
			res += rem*pow;
			pow *= 10;
		}
		return res;

//		python code
//		pow = 1
//		res = 0
//		while n != 0:
//		    rem = n % 2
//		    n //= 2
//		    res += rem * pow
//		    pow *= 10
//		return res

	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		int sc = (int)Math.pow(2, n);
		
		int power = (int)Math.pow(10, n-1);
		
		for(int i = 0 ; i < sc; i++) {
			int bn = getBinary(i);
			
			int pow = power;
			
			for(int j =  0 ; j < n ; j++) {
				int digit = bn/pow;
				bn = bn%pow;
				pow = pow/10;
				
				if(digit == 0) {
					System.out.print("-\t");
				}else {
					System.out.print(arr[j] + "\t");
				}
			}
			System.out.println();
		}
		
//		python code
//		n = int(input())
//		arr = []
//		for i in range(n):
//		    arr.append(int(input()))
//		sc = 2 ** n
//		power = 10 ** (n-1)
//		for i in range(sc):
//		    bn = getBinary(i)
//		    bn = '0' * (n - len(bn)) + bn
//		    pow = power
//		    for j in range(n):
//		        digit = int(bn[j])
//		        if digit == 0:
//		            print("-\t", end="")
//		        else:
//		            print(arr[j], "\t", end="")
//		    print()
		
	}

}
