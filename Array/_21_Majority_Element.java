package Array;

public class _21_Majority_Element {

    static int majorityElement(int arr[], int size)
    {
        int maxEle = arr[0];
        int occ = 1;
        for(int i = 1; i < size ; i++){
            if(arr[i] == maxEle){
                occ++;
            }else{
                occ--;
            }
            if(occ == 0){
                maxEle = arr[i];
                occ = 1;
            }
        }
        
        occ = 0;
        for(int i : arr){
            if(i == maxEle){
                occ++;
            }
        }
        
        return occ > size/2 ? maxEle:-1; 
    }
	
}
