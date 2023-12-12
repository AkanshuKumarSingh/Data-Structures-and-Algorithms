package Basics;

import java.util.Scanner;

public class isPrime_best {
	
	// best sol for finding prime whether no is prime or not O(√n) sol

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-- > 0){
            int no = scan.nextInt();
            boolean flag = true;
            for(int i = 2; i*i <= no; i++){
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
