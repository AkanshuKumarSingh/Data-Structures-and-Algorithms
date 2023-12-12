package Pattern;

import java.util.Scanner;

public class pattern20 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		
		for(int r = 0; r < row; r++) {
			System.out.print("*\t");
			if(row == 1)break; // just one
			if(r >= row/2) {
				for(int c = 1; c < row-1; c++) {
					if(r+c == row-1 || r == c) {
						System.out.print("*\t");
					}else {
						System.out.print("\t");
					}
				}
			}else {
				for(int i = 0 ; i < row-2; i++) {
					System.out.print("\t");
				}
			}
			System.out.println("*\t");
		}
		
//		for (int i = 0; i < r; i++) {
//			for(int j = 0; j < r; j++) {
//				if((j == 0) || (j == r-1) || (i >= r/2 && i+j == r-1)
//						|| (i >= r/2 && i == j)) {
//					System.out.print("*\t");
//				}else {
//					System.out.print("\t");
//				}
//			}
//			System.out.println();
//		}
		
		scan.close();
		
	}

}
