package Time_and_space;

import java.util.Scanner;

public class Solve_polynomial_equation {

	public static int function(int x, int n) {
		int sum = 0;
		int pow = x;
		for(int i = n; i > 0; i--) {
			sum += (i*(pow));
			pow = pow*x;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int n = scan.nextInt();
		System.out.println(function(x,n));
		
	}

}
