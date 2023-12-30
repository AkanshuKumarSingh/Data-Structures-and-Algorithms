package Recursion_and_Backtracking;

public class _51_Recursive_sequence {

    static long sequence(int N){
        int i = 1;
        long ans = 0, no = 1;
        while(i <= N){
            
            long temp = 1;
            for(int j = 1; j <= i; j++){
                temp = temp*no;
                no++;
            }
            
            ans += temp;
            i++;
        }
        
        return ans;
    }
	
}
