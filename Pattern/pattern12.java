package Pattern;

import java.util.Scanner;

public class pattern12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int a = 0,b = 1,c = 0;
		
		for(int r = 0; r < row; r++) {
			for(int i = 0 ; i <= r; i++) {
				System.out.print(a + "\t");
				c = a+b;
				a = b;
				b = c;
			}
			System.out.println();
		}
		scan.close();
	}

}
