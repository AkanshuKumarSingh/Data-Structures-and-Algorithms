package Recursion_on_way_up;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {

	// https://leetcode.com/problems/generate-parentheses/

	public static List<String> generateParenthesis(int n) {

		List<String> rres = generateParenthesis(n - 1);
		List<String> cres = new ArrayList<>();
		for (String t : rres) {
			cres.add("(" + t + ")");
		}

		return null;
	}

	public static void main(String[] args) {

		try {
			int a[] = new int[5];
			a[5] = 30 / 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("task 2 completed");
		} catch (ArithmeticException e) {
			System.out.println("task1 is completed");
		} catch (Exception e) {
			System.out.println("common task completed");
		}
		System.out.println("rest of the code...");

//		System.out.println(generateParenthesis(3));
	}

}
