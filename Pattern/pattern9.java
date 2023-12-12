package Pattern;

import java.util.Scanner;

public class pattern9 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
// first way
//		int star = 2,space1 = 0,space2 = row - 1;
//		
//		for(int r = 0; r < row; r++) {
//			for(int sp = 1; sp <= space1; sp++) {
//				System.out.print("\t");
//			}
//			System.out.print("*");
//			for(int sp = 1; sp <= space2; sp++) {
//				System.out.print("\t");
//			}
//			if(r != row/2)
//				System.out.print("*");
//			System.out.println();
//			if(r < row/2) {
//				space1++;
//				space2 -= 2;
//			}else {
//				space1--;
//				space2 += 2;
//			}
//		}
//		
//		
		
		for(int r = 0; r < row; r++) {
			int cnt = 0;
			for(int c = 0; c < row; c++) {
				if(r == c || r+c == row-1) {
					System.out.print("*\t");
					cnt++;
				}else {
					System.out.print("\t");
				}
//				if(cnt == 2 || r == row/2 && cnt == 1) {
//					break;
//				}
			}
			System.out.println();
		}
		
		int space1 = 0,space2 = row-2;
		for(int r = 1; r <= row; r++) {
			for(int sp = 1; sp <= space1; sp++) {
				System.out.print("\t");
			}
			System.out.print("*\t");
			for(int sp = 1; sp <= space2; sp++) {
				System.out.print("\t");
			}
			if(r != row/2 + 1) {
				System.out.print("*");
			}
			System.out.println();
			if(r <= row/2) {
				space1++;
				space2 -= 2;
			}else {
				space1--;
				space2 += 2;
			}
		}
		
		scan.close();
	}

}
