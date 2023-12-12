package Pattern;

import java.util.Scanner;

public class pattern3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int star = 1,space = row-1;
		for(int r = 1 ; r <= row; r++) {
			for(int sp  = 1 ; sp <= space; sp++) {
				System.out.print("\t");
			}
			for(int st = 1; st <= star; st++) {
				System.out.print("*\t");
			}
			System.out.println();
			star++;
			space--;
		}
		scan.close();
	}

}
