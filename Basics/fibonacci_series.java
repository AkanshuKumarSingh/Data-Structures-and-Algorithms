package Basics;

import java.util.Scanner;

public class fibonacci_series {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// idea is instead of addition we print a it will give us same sequence 
		// without handling for 0 and 1 becaz at the end a is getting assigned value
		// of b and b gets assigned c so gets each value this concept is nice
	      int n = scan.nextInt();
	      int a = 0;
	      int b = 1;
	      for(int i = 0 ; i < n ; i++){
	          int c = a+b;
	          System.out.println(a);
	          a = b;
	          b = c;
	      }
	      scan.close();
	}

}
