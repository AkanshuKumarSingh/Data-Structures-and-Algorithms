package Sorting;

import java.util.Arrays;

public class _36_Maximize_Toys {

    static int toyCount(int N, int K, int arr[])
    {
		Arrays.sort(arr);
		int count = 0;
		for(int j = 0 ; j < N ; j++) {
			if(K - arr[j] > 0) {
				count++;
				K -= arr[j];
			}else if(K - arr[j] == 0) {
				count++;
				break;
			}else {
				break;
			}
		}
		return count;
    }

//    def toyCount(N, K, arr):
//        arr.sort()
//        count = 0
//        for price in arr:
//            if K - price > 0:
//                count += 1
//                K -= price
//            elif K - price == 0:
//                count += 1
//                break
//            else:
//                break
//        return count

    
}
