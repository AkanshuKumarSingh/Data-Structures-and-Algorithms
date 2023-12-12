package Pattern;

import java.util.Scanner;

public class pattern18 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int star = row, space = 0;
		
		for(int r = 0; r < row; r++) {
			for(int sp = 0; sp < space; sp++) {
				System.out.print("\t");
			}
			for(int st = 0; st < star; st++) {
				if(r == 0 || r >= row/2 || st == 0 || st == star-1)
					System.out.print("*\t");
				else {
					System.out.print("\t");
				}
			}
			if(r < row/2) {
				star -= 2;
				space++;
			}else {
				star += 2;
				space--;
			}
			System.out.println();
		}
		System.out.println("\n");
		for(int r = 0; r < row; r++) {
			for(int c = 0 ; c < row; c++) {
				if(r == 0 || r == c || r+c == row-1 || (r > c && r+c > row-1)) {
					System.out.print("*\t");
				}else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
		
		scan.close();
		
	}

}