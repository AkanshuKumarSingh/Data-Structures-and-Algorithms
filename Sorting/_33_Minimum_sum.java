package Sorting;

import java.util.Arrays;
import java.util.Stack;

public class _33_Minimum_sum {

	static String solve(int[] arr, int n) {

		Arrays.sort(arr);
		Stack<Integer> no1 = new Stack<>(), no2 = new Stack<>();
		int i = 0;
		for (i = 0; i < n; i += 2) {
			no1.push(arr[i]);
			if (i + 1 < n)
				no2.push(arr[i + 1]);
		}

		String ans = "";
		int carry = 0;
		while (!no1.isEmpty() || carry != 0) {
			int n1 = no1.isEmpty() ? 0 : no1.pop();
			int n2 = no2.isEmpty() ? 0 : no2.pop();
			int sum = (n1 + n2 + carry);
			if (sum == 0)
				break;
			carry = sum / 10;
			sum = sum % 10;
			ans = sum + ans;
		}

		if (ans == "") {
			ans = "0";
		}

		return ans;

	}

//	def solve(arr):
//	    arr.sort()
//	    no1 = []
//	    no2 = []
//	    
//	    for i in range(0, len(arr), 2):
//	        no1.append(arr[i])
//	        if i + 1 < len(arr):
//	            no2.append(arr[i + 1])
//	    
//	    ans = ""
//	    carry = 0
//	    
//	    while no1 or carry != 0:
//	        n1 = no1.pop() if no1 else 0
//	        n2 = no2.pop() if no2 else 0
//	        total = n1 + n2 + carry
//	        if total == 0 and not no1 and not no2 and carry == 0:
//	            break
//	        carry = total // 10
//	        ans = str(total % 10) + ans
//
//	    if ans == "":
//	        ans = "0"
//	    
//	    return ans

	
	public static void main(String args[]) {
		System.out.println(solve(new int[] { 0, 0, 0, 0, 0 }, 5));
	}

}
