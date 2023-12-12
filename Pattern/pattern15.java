package Pattern;

import java.util.Scanner;

public class pattern15 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int no = 1,star = 1,space = n/2;
		
		for(int i = 1; i <= n; i++) {
			for(int sp = 1; sp <= space; sp++) {
				System.out.print("\t");
			}
			
			int newNo = no;
			for(int st = 1; st <= star; st++) {
				System.out.print(newNo + "\t");
				if(st <= star/2) {
					newNo++;
				}else {
					newNo--;
				}
			}
			
			if(i <= n/2) {
				star += 2;
				space--;
				no++;
			}else {
				star -= 2;
				space++;
				no--;				
			}
			
			System.out.println();
		}
		
		scan.close();
	}

}
