package Time_and_space;

public class StableCountSort {
	// Stable count sort : doesn't change the order

	public static void stableSort(int arr[], int min, int max, char chars[]) {
		int range = max - min + 1;
		int freq[] = new int[range];

		for (int i = 0; i < arr.length; i++) {
			int indx = arr[i] - min;
			freq[indx]++;
		}

		for (int i = 1; i < range; i++) {
			freq[i] += freq[i - 1];
		}

		int ans[] = new int[arr.length];
		char ch[] = new char[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			int indx = arr[i] - min;
			int pos = freq[indx];
			ans[pos-1] = arr[i];
			ch[pos-1] = chars[i];
			freq[indx]--;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(ch[i] + " ");
			arr[i] = ans[i];
			chars[i] = ch[i];
		}
	}

	public static void main(String args[]) {
		int arr[] =    { 3,    1,   5,   7,   6,   9,   8,   5,   3,   3,   1,   2 };
		char chars[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l' };
		stableSort(arr, 1, 9, chars);
	}

}
