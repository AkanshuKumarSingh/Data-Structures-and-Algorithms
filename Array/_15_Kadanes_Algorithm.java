package Array;

public class _15_Kadanes_Algorithm {

	public static void main(String[] args) 
    {
        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
    }
 
    // Function Call
    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, sum = 0;
        for(int i = 0 ; i < a.length; i++) {
        	sum  = sum + a[i];
        	max_so_far = Math.max(max_so_far, sum);
        	sum = sum < 0 ? 0:sum;
        }
        return max_so_far;
    }

}
