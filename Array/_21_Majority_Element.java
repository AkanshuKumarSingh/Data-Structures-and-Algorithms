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

//    def majority_element(arr):
//        size = len(arr)
//        max_ele = arr[0]
//        occ = 1
//
//        for i in range(1, size):
//            if arr[i] == max_ele:
//                occ += 1
//            else:
//                occ -= 1
//            if occ == 0:
//                max_ele = arr[i]
//                occ = 1
//
//        # Verify if it's truly a majority
//        occ = sum(1 for x in arr if x == max_ele)
//        return max_ele if occ > size // 2 else -1

}
