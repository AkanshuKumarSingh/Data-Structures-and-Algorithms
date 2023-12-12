package Pattern;

import java.util.Scanner;

public class pattern6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
//		int space = 1, star = row / 2 + 1;
//
//		for (int r = 0; r < row; r++) {
//			for (int st = 1; st <= star; st++) {
//				System.out.print("*\t");
//			}
//			for (int sp = 1; sp <= space; sp++) {
//				System.out.print("\t");
//			}
//			for (int st = 1; st <= star; st++) {
//				System.out.print("*\t");
//			}
//			System.out.println();
//
//			if (r < row / 2) {
//				star--;
//				space += 2;
//			} else {
//				star++;
//				space -= 2;
//			}
//		}
//		scan.close();
//
//		System.out.println("\n");
//		
//		// Using Linear Prgramming
//		int n = row;
//		for (int r = 1; r <= row; r++) {
//			for (int c = 1; c <= row + 2; c++) {
//				if (r + c >= (n+3) / 2 && r - c <= n / 2 && -r + c <= (n+3) / 2 && r + c <= 2*n) {
//					System.out.print("*\t");
//				} else {
//					System.out.print("\t");
//				}
//			}
//			System.out.println();
//		}
//
//		System.out.println("\n");
//		for (int r = 1; r <= row; r++) {
//			for (int c = 1; c <= row + 2; c++) {
//				if (r + c > (n+3) / 2 && r - c < n / 2 && -r + c < (n+3) / 2 && r + c < 2*n) {
//					System.out.print("\t");
//				} else {
//					System.out.print("*\t");
//				}
//			}
//			System.out.println();
//		}
//		
//		System.out.println(row);
//		
//		for(int r = 0; r < row; r++) {
//			for(int c = 0; c < row + 2; c++) {
//				if(		r+c <= row/2 ||
//						c-r > (row+2)/2 || 
//						r-c >= row/2 || 
//						r+c >= (row/2 + row+1)
//						) {
//					System.out.print("*\t");
//				}else {
//					System.out.print("\t");
//				}
//			}
//			System.out.println();
//		}
//		
//		
//		star = row/2 + 1;
//		space = 1;
//        for(int r = 1; r <= row; r++){
//            for(int st = 1; st <= star; st++){
//                System.out.print("*\t");
//            }
//            for(int sp = 1; sp <= space; sp++){
//                System.out.print("\t");
//            }
//            for(int st = 1; st <= star; st++){
//                System.out.print("*\t");
//            }
//            if(r <= row/2){
//                star--;
//                space += 2;
//            }else{
//                star++;
//                space -= 2;
//            }
//            System.out.println();
//        }
//        
        int star = row/2 + 1, space = 1;
        for(int r = 1; r <= row; r++){
            for(int c = 1; c <= row + 2; c++){
                if(r+c <= (row+2)/2 + 1 || c-r >= (row+2)/2 + 1
                		|| r-c >= row/2	 || r+c >= (row+2)/2 + row+2
                		){
                    System.out.print("*\t");
                }else {
                	System.out.print("\t");
                }
            }
            System.out.println();
        }
		
        System.out.println("\n");
        
        for(int r = 1; r <= row ; r++) {
        	for(int c = 1; c <= row + 2; c++) {
        		if(r+c <= (row+3)/2 || c-r >= (row+3)/2 || r-c >= row/2 || r+c >= (row+3)/2 + row+1) {
        			System.out.print("*\t");
        		}else {
        			System.out.print("\t");
        		}
        	}
        	System.out.println();
        }
        
	}

}
