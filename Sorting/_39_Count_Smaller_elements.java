package Sorting;

public class _39_Count_Smaller_elements {

	static void merge(int di[][], int ans[], int l, int m, int r) {
		int t[][] = new int[r - l + 1][2];
		int n1 = m - l + 1;
		int n2 = r - m;
		int k = 0;
		int i = l, j = m + 1;
		while (i <= m && j <= r) {
			if (di[i][0] <= di[j][0]) {
				t[k][0] = di[i][0];
				t[k][1] = di[i][1];
				ans[di[i][1]] += (j - m - 1);
				i++;
			} else {
				t[k][0] = di[j][0];
				t[k][1] = di[j][1];
				j++;
			}
			k++;
		}

		while (i <= m) {
			t[k][0] = di[i][0];
			t[k][1] = di[i][1];
			ans[di[i][1]] += (j - m - 1);
			i++;
			k++;
		}

		while (j <= r) {
			t[k][0] = di[j][0];
			t[k][1] = di[j][1];
			j++;
			k++;
		}

		k = 0;
		for (i = l; i <= r; i++) {
			di[i][0] = t[k][0];
			di[i][1] = t[k][1];
			k++;
		}

	}

	static void mergeSort(int di[][], int ans[], int l, int r) {
		if (l >= r)
			return;
		int m = l + (r - l) / 2;
		mergeSort(di, ans, l, m);
		mergeSort(di, ans, m + 1, r);
		merge(di, ans, l, m, r);
	}

	static int[] constructLowerArray(int[] arr, int n) {
		int ans[] = new int[n];
		int di[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			di[i][0] = arr[i];
			di[i][1] = i;
		}
		mergeSort(di, ans, 0, n - 1);
		return ans;
	}

//	from typing import List
//
//	def merge(di: List[List[int]], ans: List[int], l: int, m: int, r: int):
//	    t = [[0, 0] for _ in range(r - l + 1)]
//	    i, j, k = l, m + 1, 0
//
//	    while i <= m and j <= r:
//	        if di[i][0] <= di[j][0]:
//	            t[k][0] = di[i][0]
//	            t[k][1] = di[i][1]
//	            ans[di[i][1]] += (j - m - 1)
//	            i += 1
//	        else:
//	            t[k][0] = di[j][0]
//	            t[k][1] = di[j][1]
//	            j += 1
//	        k += 1
//
//	    while i <= m:
//	        t[k][0] = di[i][0]
//	        t[k][1] = di[i][1]
//	        ans[di[i][1]] += (j - m - 1)
//	        i += 1
//	        k += 1
//
//	    while j <= r:
//	        t[k][0] = di[j][0]
//	        t[k][1] = di[j][1]
//	        j += 1
//	        k += 1
//
//	    for x in range(k):
//	        di[l + x][0] = t[x][0]
//	        di[l + x][1] = t[x][1]
//
//	def mergeSort(di: List[List[int]], ans: List[int], l: int, r: int):
//	    if l >= r:
//	        return
//	    m = l + (r - l) // 2
//	    mergeSort(di, ans, l, m)
//	    mergeSort(di, ans, m + 1, r)
//	    merge(di, ans, l, m, r)
//
//	def constructLowerArray(arr: List[int], n: int) -> List[int]:
//	    ans = [0] * n
//	    di = [[arr[i], i] for i in range(n)]
//	    mergeSort(di, ans, 0, n - 1)
//	    return ans

	
}
