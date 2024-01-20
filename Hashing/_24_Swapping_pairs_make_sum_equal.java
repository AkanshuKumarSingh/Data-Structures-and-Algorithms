package Hashing;

import java.util.Arrays;

public class _24_Swapping_pairs_make_sum_equal {

    long findSwapValues(long A[], int n, long  B[], int m)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        long sum1 = 0, sum2 = 0;
        for(long no : A) sum1 += no;
        for(long no : B) sum2 += no;
        
        int i = 0, j = 0;
        while(i < n && j < m){
            long t1 = sum1-A[i]+B[j];
            long t2 = sum2+A[i]-B[j];
            if(t1 == t2) return 1;
            else if(t1 > t2){
                i++;
            }else{
                j++;
            }
        }
        return -1;
    }
	
}
