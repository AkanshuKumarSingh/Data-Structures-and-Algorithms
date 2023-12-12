package Pattern;

import java.util.Scanner;

public class pattern19 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {

				if ((i == 0 && j < n / 2) || (i == n / 2 && j < n / 2) 
						|| (i >= n / 2 && j == 0)) {
					System.out.print("*\t");
				} else if (j < n / 2) {
					System.out.print("\t");
				}

				if (j == n / 2) {
					System.out.print("*\t");
				}

				if ((i < n/2 && j == n - 1) || (i == n / 2 && j > n / 2) 
						|| (i == n - 1 && j > n / 2)) {
					System.out.print("*\t");
				} else if (j > n / 2) {
					System.out.print("\t");
				}

			}

			System.out.println();
		}

//		for (int i = 0; i < r; i++) { better becaz in one checking
//			for(int j = 0 ; j < r; j++) {
//				if((i == 0 && j < r/2) || (j == r/2) || (j == r-1 && i < r/2)
//						|| (i == r/2) || (i > r/2 && j == 0) 
//						|| (i  == r-1 && j > r/2)) {
//					System.out.print("*\t");
//				}else {
//					System.out.print("\t");
//				}
//			}
//			System.out.println();
//		}
		
		System.out.println("\n");
		int row = n;
		for(int r = 1; r <= row; r++){
	        for(int c = 1; c <= row; c++){
	            if((r == 1 && c <= row/2) || 
	                (c == row/2 + 1) || 
	                (c == row && r <= row/2) || 
	                (r == row/2 + 1) || 
	                (c == 1 && r > row/2) || 
	                (r == row && c > row/2))
	            {
	                System.out.print("*\t");
	            }else{
	                System.out.print("\t");
	            }
	        }
	        System.out.println();
	    }

		
	}

}
