package Basics;

import java.util.Scanner;

public class isPrime {
	
	// Check if a number is prime better approaches are also available

	public static void main(String[] args) {
		System.out.println("HHM");
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-- > 0){
            int no = scan.nextInt();
            boolean flag = false;
            for(int i = 2; i < no; i++){
                if(no%i == 0){
                	flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("prime");
            }else{
                System.out.println("not prime");                
            }
        }
        scan.close();
	}

}
