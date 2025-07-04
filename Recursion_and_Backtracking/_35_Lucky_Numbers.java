package Recursion_and_Backtracking;

public class _35_Lucky_Numbers {

    public static int counter = 2;
    
    // Returns 1 if n is a lucky no.
    // otherwise returns 0
    static boolean find(int n)
    {
    	System.out.println(n + " " + counter);
        if (counter > n)
            return true;
        if (n % counter == 0)
            return false;
 
        /*calculate next position of input no.
        Variable "next_position" is just for
        readability of the program we can
        remove it and update in "n" only */
        int next_position = n - (n / counter);
 
        counter++;
        return find(next_position);
    }
    
    
    static boolean isLucky(int n){
        counter = 2;
        return find(n);
    }
    
//    class Solution:
//        
//        counter = 2
//        
//        def find(self, n):
//            if n < Solution.counter:
//                return True;
//            if n%Solution.counter == 0:
//                return False;
//            next_no = n-(n//Solution.counter)
//            Solution.counter += 1;
//            return self.find(next_no)
//
//        def isLucky(self, n): 
//            Solution.counter = 2
//            return self.find(n)
//                
    
    public static void main(String args[]) {
    	System.out.println(isLucky(4));
    }
	
}
