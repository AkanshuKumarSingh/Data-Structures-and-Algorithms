package Pattern;

import java.util.Scanner;

public class pattern7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
//		int space = 0;
//		for(int r = 1; r <= row; r++) {
//			for(int sp = 1; sp <= space; sp++) {
//				System.out.print("\t");
//			}
//			System.out.println("*");
//			space++;
//		}
//		
		for(int r = 0; r < row; r++) {
			for(int c= 0; c < row; c++) {
				if(r == c) {
					System.out.print("*\t");
					break;
				}else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
		
		scan.close();
	}

}
