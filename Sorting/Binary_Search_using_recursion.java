package Sorting;

public class Binary_Search_using_recursion {

	public static int binarySearch(int arr[],int start, int end, int no) {
		if(start > end) {
			return -1;
		}
		int mid = start + (end-start)/2;
		if(arr[mid] == no) {
			return mid;
		}else if(arr[mid] > no) {
			return binarySearch(arr, start,mid-1,no);
		}else
			return binarySearch(arr, mid+1,end,no);
	}
	
	public static boolean binarySearch1(int arr[],int start, int end, int no) {
		if(start > end) {
			return false;
		}
		int mid = start + (end-start)/2;
		if(arr[mid] == no) {
			return true;
		}else if(arr[mid] > no) {
			return binarySearch1(arr, start,mid-1,no);
		}else
			return binarySearch1(arr, mid+1,end,no);
	}
	
	public static int linearSearch(int arr[], int no) {
		int idx = -1;
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i] == no) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,4,5,6,7,8,9,10};
		int no = 2;
		System.out.println(binarySearch(arr,0,arr.length-1,no));
		System.out.println(binarySearch1(arr,0,arr.length-1,no));
		System.out.println(linearSearch(arr,no));
	}

}
