package Time_and_space;

import java.util.Arrays;
import java.util.Stack;

public class _33_Minimum_sum {

    String solve(int[] arr, int n) {
        Arrays.sort(arr);
        Stack<Integer> no1 = new Stack<>(), no2 = new Stack<>();
        int i = 0, carry = 0;
        for(i = 0; i < n-2; i += 2){
            no1.push(arr[i]);
            no2.push(arr[i+1]);
        }
        no1.push(arr[i]);
        if(i+1 < n)
            no2.push(arr[i+1]);
        
        String ans = "";
        while(!no2.isEmpty()){
            int n1 = no1.pop();
            int n2 = no2.pop();
            int sum = (n1+n2+carry);
            if(sum == 0) break;
            carry = sum/10;
            sum = sum%10;
            ans = sum + ans;
        }
        
        if(!no1.isEmpty() || carry != 0){
            if(!no1.isEmpty() && no1.peek() + carry != 0)
                ans = (no1.pop() + carry) + ans;
            else if(carry != 0){
                ans = carry + ans;
            }
        }
        if(ans == ""){
            ans = "0";
        }
        
        return ans;
    }
	
}
