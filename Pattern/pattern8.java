package Pattern;

import java.util.Scanner;

public class pattern8 {

	public static void main(String[] args) {
		System.out.println("JSR");
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
//		int space = row-1;
//		
//		for(int r = 0; r < row; r++) {
//			for(int sp = 1; sp <= space; sp++) {
//				System.out.print("\t");
//			}
//			System.out.println("*");
//			space--;
//		}
//		
		
		for(int r = 1; r <= row; r++) {
			for(int c = 1; c <= row; c++) {
				if(r+c == row+1) {
					System.out.println("*");
					break;
				}else {
					System.out.print("\t");
				}
			}
		}
		scan.close();
		
	}

}
