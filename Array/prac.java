package Array;

import java.util.Scanner;

public class prac {

	public static int getBinary(int no) {
		int ans = 0, pow = 1;
		while(no != 0) {
			int rem = no%2;
			no = no/2;
			ans = ans + pow*rem;
			pow = pow*10;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		for(int i: arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int mainPow = (int)Math.pow(10, n-1);
		int no = (int)Math.pow(2, n);
		for(int i = 0; i < no; i++) {
			int binary = getBinary(i);
			int pow = mainPow;
			
			for(int j = 0; j < n; j++) {
				int d = binary/pow;
				binary = binary%pow;
				pow = pow/10;
				
				if(d == 0) {
					System.out.print("_\t");;
				}else {
					System.out.print(arr[j]+"\t");
				}
			}
			System.out.println();
		}
		
	}

}
