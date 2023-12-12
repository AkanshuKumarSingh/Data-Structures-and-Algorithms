package Pattern;

import java.util.Scanner;

public class pattern5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int star = 1, space = row/2;
		for(int r = 0; r < row; r++) {
			for(int sp = 1; sp <= space; sp++) {
				System.out.print("\t");
			}
			for(int st = 1; st <= star; st++) {
				System.out.print("*\t");
			}
			System.out.println();
		
			if(r < row/2) {
				space--;
				star += 2;
			}else {
				space++;
				star -= 2;
			}
		}
		
		
		// Using Linear Prgramming
		int n = row;
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < row; c++) {
				if(r+c >= n/2 && r-c <= n/2 && -r+c <= n/2 && r+c <= n/2 + n-1) {
					System.out.print("*\t");
				}else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
		
		for(int r = 1; r <= row;r++) {
				for(int c = 1; c <= row; c++) {
					if(r+c >= row/2 + 2 && c-r  <= row/2 && r+c <= row/2+n+1 && r-c <= row/2) {
							System.out.print("*\t");
					}else {
						System.out.print("\t");
					}
				}
				System.out.println();
		}

		System.out.println("\n");
		
		for(int r = 1; r <= row; r++) {
			for(int c = 1; c <= row; c++) {
				if(r+c >= (row+3)/2 && c-r <= (row/2) && r-c <= (row/2) && r+c <= (row+3)/2 + row-1 ) {
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
