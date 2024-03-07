package Recursion_and_Backtracking;

public class _45_Finding_Position {

    static long nthPosition1(long n){
        if(n == 1) return 1;
        return nthPosition(n/2)*2;
    }
	
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
