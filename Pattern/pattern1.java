package Pattern;

import java.util.Scanner;

public class pattern1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Count stars and space in each steps
		
		int row = scan.nextInt();
		int star = 1;
		for(int r = 1 ; r <= row; r++) {
			for(int st = 1; st <= star; st++) {
				System.out.print("*\t");
			}
			System.out.println();
			star++;
		}
		scan.close();
		
	
	}

}
