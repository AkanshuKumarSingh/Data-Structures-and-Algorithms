package Recursion_and_Backtracking;

public class _45_Finding_Position {

    static long nthPosition(long n){
        long ans = -1;
        for(int i = 0; i < 8*Long.BYTES; i++){
            long no = 1<<i;
            if(no > n) break;
            ans = no;
        }
        return ans;
    }
	
}
