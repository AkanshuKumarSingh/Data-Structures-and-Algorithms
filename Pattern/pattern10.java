package Pattern;

import java.util.Scanner;

public class pattern10 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();

//		for(int r = 0; r < row; r++) {
//			int cnt = 0;
//			for(int c = 0; c < row; c++) {
//				if(r+c == row/2 || -r+c == row/2 || r-c == row/2 || r+c == row/2 + row-1) {
//					System.out.print("*\t");
//					cnt++;
//				}else {
//					System.out.print("\t");
//				}
//				if(cnt == 2 || cnt == 1 && (r == 0 || r == r-1)) {
//					break;
//				}
//			}
//			System.out.println();
//		}
		
		    for(int r = 1; r <= row; r++){
		        for(int c = 1; c <= row; c++){
		            if(r+c == row/2 + 2 || c-r == row/2 
		            || r+c == row/2 + row+1 || r-c == row/2
		            		)
		            {
		                System.out.print("*\t");    
		            }else{
		                System.out.print("\t");
		            }
		        }
		        System.out.println();
		    }
		scan.close();
	}

}
