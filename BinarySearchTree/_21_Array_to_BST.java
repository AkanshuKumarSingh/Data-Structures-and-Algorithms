package BinarySearchTree;

public class _21_Array_to_BST {

	int ans[], idx = 0;

	void makeBST(int arr[], int st, int end) {
		if (st > end)
			return;
		int mid = st + (end - st) / 2;
		ans[idx++] = arr[mid];
		makeBST(arr, st, mid - 1);
		makeBST(arr, mid + 1, end);
	}

	public int[] sortedArrayToBST(int[] nums) {
		ans = new int[nums.length];
		makeBST(nums, 0, nums.length - 1);
		return ans;
	}

}
