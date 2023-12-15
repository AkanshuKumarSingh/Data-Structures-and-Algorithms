package Searching;

public class _3_Peak_element {

	public int peakElement(int[] arr,int n)
    {
       if(arr.length == 1){
           return 0;
       }else if(arr[0] >= arr[1]){
           return 0;
       }
       
       for(int i = 1; i < n-1; i++){
           if(arr[i] >= arr[i-1] && arr[i] >= arr[i+1])
                return i;
       }
       
       if(arr[n-1] >= arr[n-2]) return n-1;
       
       return -1;
       
    }
	
}
