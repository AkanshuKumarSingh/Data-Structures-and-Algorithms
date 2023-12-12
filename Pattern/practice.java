package Pattern;

import java.util.Scanner;

public class practice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int star = r, space = 0, start = 1;

		for (int i = 0; i < r; i++) {
			for(int j = 0; j < r; j++) {
				if((j == 0) || (j == r-1) || (i >= r/2 && i+j == r-1)
						|| (i >= r/2 && i == j)) {
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
