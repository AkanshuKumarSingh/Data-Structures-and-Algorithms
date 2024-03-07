package Sorting;

import java.util.Scanner;

public class SortDates {

	public static void sortDates(String[] arr) {
		int minDate = Integer.MAX_VALUE,maxDate = Integer.MIN_VALUE;
		int minMon = Integer.MAX_VALUE,maxMon = Integer.MIN_VALUE;
		int minYear = Integer.MAX_VALUE,maxYear = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < arr.length ; i ++) {
			int currDate = (Integer.parseInt(arr[i])/1000000)%100;
			minDate = Math.min(minDate, currDate);
			maxDate = Math.max(maxDate, currDate);
			
			int currMon = (Integer.parseInt(arr[i])/10000)%100;
			minMon = Math.min(minMon, currMon);
			maxMon = Math.max(maxMon, currMon);
			
			int currYear = (Integer.parseInt(arr[i]))%10000;
			minYear = Math.min(minYear, currYear);
			maxYear = Math.max(maxYear, currYear);
		}
//		System.out.println(minDate + " " + maxDate);
//		System.out.println(minMon + " " + maxMon);
//		System.out.println(minYear + " " + maxYear);
		
		countSort(arr,1000000,100,maxDate-minDate+1);
		countSort(arr,10000,100,maxMon-minMon+1);
		countSort(arr,1,10000,maxYear-minYear+1);
	}

	public static void countSort(String[] arr, int div, int mod, int r) {
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < arr.length; i++) {
			int currVal = (Integer.parseInt(arr[i])/div)%mod;
			min = Math.min(min, currVal);
		}
		
		String ans[] = new String[arr.length];
		int freq[] = new int[r];
		
		for(int i = 0; i < arr.length; i++) {
			int currVal = (Integer.parseInt(arr[i])/div)%mod;
			int pos = currVal-min;
			freq[pos]++;
		}
		
		for(int i = 1; i < freq.length; i++) {
			freq[i] += freq[i-1];
		}
		
		for(int i = arr.length-1; i >= 0; i--) {
			int currVal = (Integer.parseInt(arr[i])/div)%mod;
			int val = currVal-min;
			int pos = freq[val];
			ans[pos-1] = arr[i];
			freq[val]--;
		}
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = ans[i];
		}
		
	}

	public static void print(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			String str = scn.next();
			arr[i] = str;
		}
		sortDates(arr);
		print(arr);
	}

}
