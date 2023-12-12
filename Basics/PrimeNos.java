package Basics;

import java.util.Scanner;

public class PrimeNos {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int no = scan.nextInt();
		
		for(int i = 2; i*i <= no; i++) {
			while(no%i == 0) {
				System.out.print(i + " ");
				no = no/i;
			}
		}
		
		if(no > 1)
			System.out.println(no);
		
	}

}
