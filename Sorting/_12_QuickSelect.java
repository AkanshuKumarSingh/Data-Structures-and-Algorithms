package Sorting;

import java.util.Scanner;

public class _12_QuickSelect {

	  public static int quickSelect(int[] arr, int lo, int hi, int k) {
	    
	    int pivot = arr[hi];
	    int pi = partition(arr,pivot,lo,hi);
	    if(pi > k){
	        return quickSelect(arr,lo,pi-1,k);
	    }else if(pi < k){
	        return quickSelect(arr,pi+1,hi,k);
	    }else{
	        return arr[pi];
	    }

	  }

	  public static int partition(int[] arr, int pivot, int lo, int hi) {
	    System.out.println("pivot -> " + pivot);
	    int i = lo, j = lo;
	    while (i <= hi) {
	      if (arr[i] <= pivot) {
	        swap(arr, i, j);
	        i++;
	        j++;
	      } else {
	        i++;
	      }
	    }
	    System.out.println("pivot index -> " + (j - 1));
	    return (j - 1);
	  }

//	  def quick_select(arr, lo, hi, k):
//		    pivot = arr[hi]
//		    pi = partition(arr, pivot, lo, hi)
//
//		    if pi > k:
//		        return quick_select(arr, lo, pi - 1, k)
//		    elif pi < k:
//		        return quick_select(arr, pi + 1, hi, k)
//		    else:
//		        return arr[pi]
//
//		def partition(arr, pivot, lo, hi):
//		    print("pivot ->", pivot)
//		    i = lo
//		    j = lo
//		    while i <= hi:
//		        if arr[i] <= pivot:
//		            arr[i], arr[j] = arr[j], arr[i]
//		            i += 1
//		            j += 1
//		        else:
//		            i += 1
//		    print("pivot index ->", j - 1)
//		    return j - 1

	  
	  // used for swapping ith and jth elements of array
	  public static void swap(int[] arr, int i, int j) {
	    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	  }

	  public static void print(int[] arr) {
	    for (int i = 0; i < arr.length; i++) {
	      System.out.print(arr[i] + " ");
	    }
	    System.out.println();
	  }

	  public static void main(String[] args) throws Exception {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++) {
	      arr[i] = scn.nextInt();
	    }
	    int k = scn.nextInt();
	    System.out.println(quickSelect(arr,0,arr.length - 1,k - 1));
	  }

}
