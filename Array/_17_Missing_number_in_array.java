package Array;

public class _17_Missing_number_in_array {

    int missingNumber(int array[], int n) {
        int sum = 0;
        for(int i: array){
            sum += i;
        }
        int expSum = (n*(n+1))/2;
        return expSum - sum;
    }

//    def missing_number(array, n):
//        total = sum(array)
//        expected_sum = (n * (n + 1)) // 2
//        return expected_sum - total

    
}
