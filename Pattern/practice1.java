package Pattern;

import java.util.Scanner;

public class practice1 {
	
//	7
//	*	*	*	*	*	*	*	
//	*	*	*	*	*	*	*	
//	*	*	*	*	*	*	*	
//	*	*	*	*	*	*	*	
//	*	*	*		*	*	*	
//	*	*				*	*	
//	*						*	


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int star = row/2, space = 1;
		
		for(int r = 0; r < row; r++) {
			if(r < row/2) {
//				System.out.println("First executed....");
				for(int st = 0; st < star; st++) {
					System.out.print("*\t");
				}
				for(int sp = 0; sp < space; sp++) {
					System.out.print("\t");
				}
				for(int st = 0; st < star; st++) {
					System.out.print("*\t");
				}
				star--;
				space += 2;
			}else {
//				System.out.println("Second executed....");
				for(int i = 0 ; i < row; i++) {
					System.out.print("*\t");
				}
			}
			System.out.println();
		}
		scan.close();
	}

}
