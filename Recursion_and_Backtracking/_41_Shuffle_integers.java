package Recursion_and_Backtracking;

public class _41_Shuffle_integers {
    void shuffleArray(long arr[], int n){
		long mod = 1001;
		for (int i = 0; i < n / 2; i++) {
			arr[i * 2] += (arr[i] % mod) * mod;
			arr[i * 2 + 1] += (arr[i + (n / 2)] % mod) * mod;
		}

		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] / mod;
		}
	}
    
    void shuffleArray1(long arr[], int n)
    {
        int a = 1, b = n/2;
        for(int i = 1; i < n-1; i++){
            if(i%2 == 1){
                arr[i] = arr[b]*10000 + arr[i];
                b++;
            }else{
                arr[i] = (arr[a]%10000)*10000 + arr[i];
                a++;
            }
        }
        
        for(int i = 1; i < n-1; i++){
            arr[i] = arr[i]/10000;
        }
    }
}
