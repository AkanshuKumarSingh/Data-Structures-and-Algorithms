package funtionAndNumberSystem;

import java.util.Scanner;

public class Any_base_addtion {
//	1. You are given a base b.
//	2. You are given two numbers n1 and n2 of base b.
//	3. You are required to add the two numbes and print their value in base b.

	  public static void main(String[] args) {
	      Scanner scn = new Scanner(System.in);
	      int b = scn.nextInt();
	      int n1 = scn.nextInt();
	      int n2 = scn.nextInt();
	  
	      int d = getSum(b, n1, n2);
	      System.out.println(d);
	   }
	  
	   public static int getSum(int b, int n1, int n2){
		   int power = 1;
	       int carry = 0;
	       int ans = 0;
	       while(n1 > 0 || n2 > 0 || carry != 0){
	           int val1 = n1%10;
	           int val2 = n2%10;
	           n1 = n1/10;
	           n2 = n2/10;
	           int sum = (val1 + val2 + carry);
	           int val = sum%b;
	           carry = sum/b;
	           ans +=(power*val);
	           power *= 10;
	       }
	       return ans;
	   }
	
}
