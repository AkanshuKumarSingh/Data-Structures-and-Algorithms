package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Pep_Combination_Sum {

	public static ArrayList<ArrayList<Integer>> combinationSum(int sum, int target, int arr[],int idx) {
		if(idx == arr.length) {
			ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
			if(sum == target) {
				ans.add(new ArrayList<Integer>());
				return ans;
			}else {
				return ans;
			}
		}
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if(sum + arr[idx] <= target) {
			ArrayList<ArrayList<Integer>> cans = combinationSum(sum+arr[idx],target,arr,idx);
			for(ArrayList<Integer> e : cans) {
				ArrayList<Integer> t = new ArrayList<>();
				t.add(arr[idx]);
				t.addAll(e);
				ans.add(t);
			}
		}
		ArrayList<ArrayList<Integer>> cans = combinationSum(sum,target,arr,idx+1);
		for(ArrayList<Integer> e : cans) {
			ans.add(e);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		int target = scan.nextInt();
		System.out.println(combinationSum(0,target,arr,0));
	}

}
