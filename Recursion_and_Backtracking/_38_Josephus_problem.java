package Recursion_and_Backtracking;

public class _38_Josephus_problem {

	   public int josephus(int n, int k)
	    {
	        if(n == 1) return 1;
	        return ((josephus(n-1, k) + k - 1) % n) + 1;
	    }
	   
	   public static void main(String args[]) {
		   System.out.println(new _38_Josephus_problem().josephus(4, 2));
	   }
	
}
