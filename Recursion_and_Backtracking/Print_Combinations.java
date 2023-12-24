package Recursion_and_Backtracking;

public class Print_Combinations {

	public static void printCombinations(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			
			char ch = str.charAt(i);
			
			String first_half = str.substring(0,i);
			String second_half = str.substring(i+1);
			
			if(i == 0 || str.charAt(i) != str.charAt(i-1))
			printCombinations(first_half + second_half, ans + str.charAt(i));
		
		}
	}

	public static void main(String[] args) {
		String str = "abbc";
		printCombinations(str, "");

	}

}
