package Time_and_space;

import java.util.Arrays;

public class _31_Count_the_number_of_possible_triangles {

    static int findNumberOfTriangles(int arr[], int n)
    {
        Arrays.sort(arr);
        int ans = 0;
        
        for(int i = 2; i < n; i++){
            int st = 0, ed = i-1;
            while(st < ed){
                if(arr[st] + arr[ed] <= arr[i]){
                    st++;
                }else{
                    ans += (ed-st);
                    ed--;
                }
            }
        }
        return ans;
    }
	
}
