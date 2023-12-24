package Recursion_and_Backtracking;

public class _33_Power_Of_Numbers {

    long power(int N,int R)
    {
        if(R == 0){
            return 1;
        }
        
        long ans = power(N, R/2);
        ans = (ans*ans)%1000000007;
        if(R%2 == 1){
            ans = ans*N;
        }
        return ans%1000000007;
    }
	
}
