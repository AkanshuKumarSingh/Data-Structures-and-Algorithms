package Pattern;

import java.util.Scanner;

public class pattern16 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int star = 1,space = 2*row - 3;
		
		for(int r = 0; r < row; r++) {
			int no = 1;
			for(int i = 0; i < star; i++) {
				System.out.print(no+"\t");
				no++;
			}
			for(int sp = 0; sp < space; sp++) {
				System.out.print("\t");
			}
			
			if(r == row-1) {
				no--;
				star--;
			}
			
			for(int i = 0; i < star; i++) {
				no--;
				System.out.print(no+"\t");
			}
			System.out.println();
			space -= 2;
			star++;
		}
		scan.close();
	}

}
