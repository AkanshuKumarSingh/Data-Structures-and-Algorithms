package Array;

public class _15_Cyclically_rotate_an_array_by_one {

	public static void reverse(int a[], int left, int right) {
		while (left < right) {
			int t = a[left];
			a[left] = a[right];
			a[right] = t;
			left++;
			right--;
		}
	}

    
    public void rotate(int arr[], int n)
    {
        reverse(arr, 0, n-1);
        reverse(arr, 1, n-1);
    }
	
//    def reverse(arr, left, right):
//        while left < right:
//            arr[left], arr[right] = arr[right], arr[left]
//            left += 1
//            right -= 1
//
//    def rotate(arr):
//        n = len(arr)
//        reverse(arr, 0, n - 1)
//        reverse(arr, 1, n - 1)
}
