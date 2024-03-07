package Sorting;

public class _42_Maximum_product_of_two_numbers {

    int maxProduct(int arr[], int n) {
        int max = -1, secondMax = -1;
        for(int i : arr){
            if(i > max){
                secondMax = max;
                max = i;
            }else if(i > secondMax){
                secondMax = i;
            }
        }
        return max*secondMax;
    }
	
}
