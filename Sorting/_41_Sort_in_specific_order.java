package Sorting;

import java.util.Arrays;

public class _41_Sort_in_specific_order {

    public static void swap(long arr[], int l, int r) {
		long t = arr[l];
		arr[l] = arr[r];
		arr[r] = t;
	}
	
    public static void reverse(long[] arr, int start, int end) {
        while (start < end) {
            long temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public void sortIt(long arr[], long n)
    {
        // System.out.println("JMP");
        int l = 0, r = (int)n-1;
		while(l < r) {
			while(arr[l]%2 != 0 && l != r) {
				l++;
			}
			while(arr[r]%2 == 0 && l != r) {
				r--;
			}
			if(l < r) {
				swap(arr,l,r);
			}
		}
        Arrays.sort(arr, 0, l);
        reverse(arr, 0, l-1);
		Arrays.sort(arr, l, (int)n);
    }
	
//    def swap(arr, l, r):
//        arr[l], arr[r] = arr[r], arr[l]
//
//    def reverse(arr, start, end):
//        while start < end:
//            arr[start], arr[end] = arr[end], arr[start]
//            start += 1
//            end -= 1
//
//    def sortIt(arr, n):
//        l, r = 0, n - 1
//        while l < r:
//            while l < r and arr[l] % 2 != 0:
//                l += 1
//            while l < r and arr[r] % 2 == 0:
//                r -= 1
//            if l < r:
//                swap(arr, l, r)
//
//        # Now all odd elements are from index 0 to l-1
//        arr[0:l] = sorted(arr[0:l], reverse=True)  # Sort odd numbers in descending order
//        arr[l:n] = sorted(arr[l:n])                # Sort even numbers in ascending order

    
}
