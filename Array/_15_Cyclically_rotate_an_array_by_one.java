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
	
}
