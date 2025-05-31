package Sorting;

import java.util.Arrays;

public class _11_Target_Sum_Pair_1 {
	
	public static void targetSum(int arr[], int target) {
		Arrays.sort(arr);
		
		int i = 0;
		int j = arr.length-1;
		while(i < j) {
			int sum = arr[i] + arr[j];
			
			if(sum == target) {
				System.out.println(arr[i] + "," + arr[j]);
				i++;
				j--;
			}else if(sum < target) {
				i++;
			}else {
				j--;
			}
			
		}

	}

//	def target_sum(arr, target):
//	    arr.sort()  # Sort the array
//
//	    i = 0
//	    j = len(arr) - 1
//
//	    while i < j:
//	        s = arr[i] + arr[j]
//
//	        if s == target:
//	            print(f"{arr[i]},{arr[j]}")
//	            i += 1
//	            j -= 1
//	        elif s < target:
//	            i += 1
//	        else:
//	            j -= 1


	public static void main(String[] args) {
		int arr[] = {10,40,20,90,50,70,30};
		targetSum(arr,70);
	}

}
