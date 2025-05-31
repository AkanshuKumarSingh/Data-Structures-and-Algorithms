package Array;

public class _23_Equilibrium_Point {

    public static int equilibriumPoint(long arr[], int n) {
        if(n == 1) return 1;
        long sum = 0, prevSum = 0;
        for(long i : arr){
            sum += i;
        }
        sum -= arr[0];
        
        for(int i = 1; i < n; i++){
            prevSum += arr[i-1];
            sum -= arr[i];
            if(sum == prevSum) return i+1;
        }
        
        return -1;
    }

//    def equilibrium_point(arr, n):
//        if n == 1:
//            return 1
//
//        total_sum = sum(arr)
//        left_sum = 0
//
//        for i in range(n):
//            total_sum -= arr[i]
//            if left_sum == total_sum:
//                return i + 1  # 1-based index
//            left_sum += arr[i]
//
//        return -1

    
}
