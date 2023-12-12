package Pattern;

import java.util.Scanner;

public class pattern13 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		// Pascal triangle every digit is sum of upper two digits see on net
		for(int i = 0; i < n; i++) {
			// each no is of form nCr i.e iCj so if we find 1st iCj of each is 
			// which is ofcourse 1 we have to find nC(r+1) which we can find by
			// Xing by (i-j)/(j+1);
			
			int var = 1;
			for(int j = 0; j <= i; j++) {
				System.out.print(var + "\t");
				var = var*(i-j)/(j+1);
			}
			System.out.println();
		}
		scan.close();
	}

}
