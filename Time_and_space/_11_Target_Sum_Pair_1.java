package Time_and_space;

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

	public static void main(String[] args) {
		int arr[] = {10,40,20,90,50,70,30};
		targetSum(arr,70);
	}

}
