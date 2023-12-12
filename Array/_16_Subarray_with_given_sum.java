package Array;

import java.util.ArrayList;

public class _16_Subarray_with_given_sum {
	
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int sum = 0, start = 0, i = 0;
        while(i < n) {
        	sum += arr[i];
        	while(sum > s) {
        		sum -= arr[start++];
        	}
        	if(sum == s && start <= i) {
        		ans.add(start+1);
        		ans.add(i+1);
        		break;
        	}
        	i++;
        }
        if(ans.size() == 0) {
        	ans.add(-1);
        }
        return ans;        // Your code here
    }
}
