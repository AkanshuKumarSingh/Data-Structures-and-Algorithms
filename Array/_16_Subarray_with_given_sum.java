package Array;

import java.util.ArrayList;

public class _16_Subarray_with_given_sum {

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		ArrayList<Integer> ans = new ArrayList<>();
		int sum = 0, start = 0, i = 0;
		while (i < n) {
			sum += arr[i];
			while (sum > s) {
				sum -= arr[start++];
			}
			if (sum == s && start <= i) {
				ans.add(start + 1);
				ans.add(i + 1);
				break;
			}
			i++;
		}
		if (ans.size() == 0) {
			ans.add(-1);
		}
		return ans; // Your code here

//      python code  
//      ans = []
//	    n = len(arr)
//	    sum_val = 0
//	    start = 0
//	    i = 0
//	    
//	    while i < n:
//	        sum_val += arr[i]
//	        
//	        while sum_val > s:
//	            sum_val -= arr[start]
//	            start += 1
//	            
//	        if sum_val == s and start <= i:
//	            ans.append(start + 1)
//	            ans.append(i + 1)
//	            break
//	        
//	        i += 1
//	    
//	    if not ans:
//	        ans.append(-1)
	}

	public static void main(String args[]) {
//		int arr[] = { 0 };
//		int n = 1, s = 0;
		int arr[] = {38, 22, 20, 12, 47, 23, 18, 13, 18, 47, 36, 42};
		int n = arr.length, s = 174;
		int st = 0, curr = 1, sumSoFar = arr[0];
		ArrayList<Integer> ans = new ArrayList<>();
//		as we can see this approach can't handle cases like when len is 9 and our sumSoFar is
//		btw idx 5 to 8 but ans is 6 to 8 so we need do sumSoFar -= arr[st]; but that handling becomes
//		bit hard to above one is good
		while (curr < n) {
			if (sumSoFar == s) {
				if(st < curr) {
					ans.add(st + 1);
					ans.add(curr);		
					break;
				}else {
					sumSoFar += arr[curr];
					curr++;	
				}
			} else if (sumSoFar < s) {
				sumSoFar += arr[curr];
				curr++;
			} else {
				sumSoFar -= arr[st];
				st++;
			}
		}


		System.out.println(sumSoFar);
	}

}
