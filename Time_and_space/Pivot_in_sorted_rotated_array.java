package Time_and_space;

public class Pivot_in_sorted_rotated_array {

	public static int findPivot(int arr[], int lo, int hi) {
		if(lo == hi) return arr[lo];
		int mid = lo + (hi-lo)/2;
		int res = 0;
		if(arr[mid] < arr[hi]) {
			return findPivot(arr,lo,mid);
		}else {
			return findPivot(arr,mid+1,hi);
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {60,70,10,20,30,40,50};
		System.out.println(findPivot(arr,0,arr.length-1));
	}

}
