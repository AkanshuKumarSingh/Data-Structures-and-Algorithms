package Basics;

import java.util.Scanner;

public class isPrime_better {
	
	// to check if no is prime, better than O(n) approach takes O(n/2) but not that much better

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-- > 0){
            int no = scan.nextInt();
            boolean flag = true;
            for(int i = 2; i <= no/2; i++){
                if(no%i == 0){
                	flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("prime");
            }else{
                System.out.println("not prime");                
            }
        }
        scan.close();
	}

}
