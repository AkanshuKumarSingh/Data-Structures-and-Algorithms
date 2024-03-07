package Array;

public class _10_binarySearch {

	public static int BinarySearch(int arr[], int n, int no) {
		int start = 0;
		int end = n-1;
		
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(arr[mid] == no) {
				return mid;
			}else if(arr[mid] < no) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
//		python code
//		   while start <= end:
//		        mid = start + (end - start) // 2
//		        if arr[mid] == no:
//		            return mid
//		        elif arr[mid] < no:
//		            start = mid + 1
//		        else:
//		            end = mid - 1
		return -1;
	}
	
	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50,60};
		System.out.println("No found at " + BinarySearch(arr,arr.length,50) + " index");
	}

}
