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
	
}
