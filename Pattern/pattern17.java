package Pattern;

import java.util.Scanner;

public class pattern17 {

	public static void main(String[] args) {
		System.out.println("HHM");

		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
//		int star = 1, space = row / 2;
//
//		for (int r = 0; r < row; r++) {
//			
//			if(r == row/2) {
//				for(int st = 0; st < star-1; st++) {
//					System.out.print("*\t");
//				}
//			}
//			
//			for (int sp = 0;r != row/2 && sp < space; sp++) {
//				System.out.print("\t");
//			}
//			for(int st = 0 ; st < star; st++) {
//				System.out.print("*\t");
//			}
//			if(r < row/2) {
//				star++;
//			}else {
//				star--;
//			}
//			System.out.println();
//		}

		int star = 1, space = row/2;
		for(int r = 0; r < row; r++) {
			for(int sp = 0; sp < space && r != row/2; sp++) {
				System.out.print("\t");
			}
			if(r == row/2) {
				for(int sp = 0; sp < row/2; sp++) {
					System.out.print("*\t");
				}		
			}
			for(int st = 0; st < star; st++) {
				System.out.print("*\t");
			}
			if(r < row/2) star++;
			else star--;
			
			System.out.println();
		}
		
		scan.close();

	}

}
