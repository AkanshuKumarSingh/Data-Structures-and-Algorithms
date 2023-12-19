package Time_and_space;

public class _20_Wave_Array {
	
    public static void convertToWave(int n, int[] arr) {
        for(int i = 0; i < n && i+1 < n ; i += 2){
            int t = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = t;
        }
    }
    
}
