package Time_and_space;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class prac {

	public static void mergeTwoSortedArrays(int low, int mid, int high, int arr[]) {
		int i = low;
		int j = mid + 1;
		int k = 0;
		int t[] = new int[high - low + 1];
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j]) {
				t[k++] = arr[i++];
			} else {
				t[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			t[k++] = arr[i++];
		}
		
		while(j <= high) {
			t[k++] = arr[j++];
		}
		k = 0;
		for(i = low; i <= high; i++) {
			arr[i] = t[k++];
		}

	}

	public static void merge_sort(int arr[], int low, int high) {
		if (low == high) {
			return;
		}

		int mid = low + (high - low) / 2;
		merge_sort(arr, low, mid);
		merge_sort(arr, mid + 1, high);

		mergeTwoSortedArrays(low, mid, high, arr);

	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		
		HashSet<ArrayList<Integer>> set = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		set.add(list);
		System.out.println(set);
		
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(3);
		list1.add(5);
		System.out.println(set.contains(list1));
		list1.addAll(list);
		System.out.println(list1);
		
		int n = Integer.parseInt(scn.nextLine());
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextLine().trim();
		}
//		merge_sort(arr, 0, arr.length - 1);
//		System.out.print("Sorted Array -> ");
//		System.out.println(Arrays.toString(arr));		
//		sortDates(arr);
	}
	
	public static void sortDates(String arr[]) {
		int minYear = Integer.MAX_VALUE, maxYear = Integer.MIN_VALUE;
		int minMonth = Integer.MAX_VALUE, maxMonth = Integer.MIN_VALUE;
		int minDate = Integer.MAX_VALUE, maxDate = Integer.MIN_VALUE;
		for(String date : arr) {
			int year = Integer.parseInt(date)%10000;
			minYear = Math.min(year, minYear);
			maxYear = Math.max(year, maxYear);
			
			int month = (Integer.parseInt(date)/10000)%100;
			minMonth = Math.min(month, minMonth);
			maxMonth = Math.max(month, maxMonth);
			
			int dateOfMonth = (Integer.parseInt(date)/1000000)%100;
			minDate = Math.min(dateOfMonth, minDate);
			maxDate = Math.max(dateOfMonth, maxDate);
		}
		
		sortDate(arr, 1000000, 100, maxDate-minDate+1, minDate);
		for(String date: arr) {
			System.out.println(date);
		}
		
		sortDate(arr, 10000, 100, maxMonth-minMonth+1, minMonth);
		for(String date: arr) {
			System.out.println(date);
		}

		sortDate(arr, 1, 10000, maxYear-minYear+1, minYear);
		for(String date: arr) {
			System.out.println(date);
		}
				

	}
	
	public static void sortDate(String arr[], int div, int mod, int range, int min) {
		String ans[] = new String[arr.length];
		System.out.println(range);
		int freq[] = new int[range];
		
		for(String date: arr) {
			int comp = (Integer.parseInt(date)/div)%mod;
			int idx = comp - min;
			freq[idx]++;
		}
		
		for(int i = 1 ; i < range; i++) {
			freq[i] += freq[i-1];
		}
		
		for(int i = arr.length-1; i >= 0; i--) {
			int comp = (Integer.parseInt(arr[i])/div)%mod;
			int idx = comp - min;
			ans[freq[idx]-1] = arr[i];
			freq[idx]--;
		}

		for(int i = 0; i < arr.length; i++) {
			arr[i] = ans[i];
		}
		
	}
	

}
