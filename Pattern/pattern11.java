package Pattern;

import java.util.Scanner;

public class pattern11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int no = 1;
		
		for(int r = 0; r < row; r++) {
			for(int i = 0 ; i <= r; i++) {
				System.out.print(no+"\t");
				no++;
			}
			System.out.println();
		}
		scan.close();
		
	}

}
