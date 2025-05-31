package Array;

public class _27_Find_Missing_And_Repeating {

    int[] findTwoElement(int arr[], int n) {
        
        int dup = -1, miss = -1;
        
        for(int i = 0; i < n; i++){
            int index = Math.abs(arr[i])-1;
            if(arr[index] > 0){
                arr[index] = -1 * arr[index];
            }else{
                dup = Math.abs(Math.abs(arr[i]));
            }
        }
        
        for(int i = 0; i < n ; i++){
            if(arr[i] > 0){
                miss = i+1;
            }
        }
        
        return new int[]{dup, miss};
    }

//    def find_two_element(arr, n):
//        dup = -1
//        miss = -1
//
//        for i in range(n):
//            index = abs(arr[i]) - 1
//            if arr[index] > 0:
//                arr[index] *= -1
//            else:
//                dup = abs(arr[i])
//
//        for i in range(n):
//            if arr[i] > 0:
//                miss = i + 1
//
//        return [dup, miss]

    
}
