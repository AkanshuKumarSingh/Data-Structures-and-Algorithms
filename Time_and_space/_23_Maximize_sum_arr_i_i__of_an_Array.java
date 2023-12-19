package Time_and_space;

import java.util.Arrays;

public class _23_Maximize_sum_arr_i_i__of_an_Array {

    int Maximize(int arr[], int n)
    {
        long result=0;
        Arrays.sort(arr);
        for(long i=0;i<n;i++){
            result += (arr[(int)i]*i);
            result = result%1000000007;
        }
        
        return (int)result;
    }   
	
}
